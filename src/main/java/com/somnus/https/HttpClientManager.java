package com.somnus.https;

import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;

public class HttpClientManager {
	
	/** 最大连接数 */
	public final static int MAX_TOTAL_CONNECTIONS 	= 800;
	/** 每个路由最大连接数 */
	public final static int MAX_PER_ROUTE			= 400;
	public final static int AFTER_INACTIVITY		= 1000;

	private static PoolingHttpClientConnectionManager defaultSSLConnManager;

	private static final Map<KeyStoreMaterial, PoolingHttpClientConnectionManager> sslConnManager = new HashMap<KeyStoreMaterial, PoolingHttpClientConnectionManager>();

	private static final Object sslLock = new Object();

	static {
		try {
			SSLContext sslcontext = SSLContexts.custom().build();
			defaultSSLConnManager = getSSLContextConnManager(sslcontext);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * getSSLConnManager:根据keyStore获取一个连接池管理器 <br/>
	 * 
	 * @param keyStore
	 * @return
	 * @since JDK 1.7
	 */
	public static PoolingHttpClientConnectionManager getSSLConnManager(KeyStoreMaterial keyStore) {
		if (keyStore == null) {
			return defaultSSLConnManager;
		}
		PoolingHttpClientConnectionManager cm = sslConnManager.get(keyStore);
		if (cm == null) {
			synchronized (sslLock) {
				cm = sslConnManager.get(keyStore);
				if (cm == null) {
					cm = initConnManager(keyStore);
					sslConnManager.put(keyStore, cm);
				}
			}
		}
		return cm;
	}

	/**
	 * initConnManager:根据参数实例化一个连接池 <br/>
	 * 
	 * @param path
	 * @param password
	 * @return
	 * @since JDK 1.7
	 */
	protected static PoolingHttpClientConnectionManager initConnManager(String path, String password) {
		PoolingHttpClientConnectionManager connManager = null;
		try {
			// SSLContext 可以加载客户端证书，或者不加载客户端证书
			// 需要加载服务器证书
			SSLContext sslcontext = null;
			if (!StringUtils.isEmpty(path) || !(StringUtils.isEmpty(password))) {
				sslcontext = SSLContexts.custom().build();
			} else {
				KeyStoreMaterial keyStore = KeyStoreUtil.getKeyStore(path, password);
				if (keyStore == null) {
					throw new RuntimeException("keyStore not found for path:" + path + ",password=" + password);
				}
				sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore.getKeyStore(), keyStore.getPassword().toCharArray()).build();
			}
			connManager = getSSLContextConnManager(sslcontext);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connManager;
	}

	/**
	 * initConnManager:根据keyStore实例化一个连接池<br/>
	 * 
	 * @param keyStore
	 * @return
	 * @since JDK 1.7
	 */
	protected static PoolingHttpClientConnectionManager initConnManager(KeyStoreMaterial keyStore) {
		PoolingHttpClientConnectionManager connManager = null;
		try {
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore.getKeyStore(), keyStore.getPassword().toCharArray()).build();
			connManager = getSSLContextConnManager(sslcontext);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connManager;
	}

	/**
	 * getSSLContextConnManager: 根据SSLContext初始化一个连接管理器 <br/>
	 * 
	 * @param sslc
	 * @return
	 * @since JDK 1.7
	 */
	private static PoolingHttpClientConnectionManager getSSLContextConnManager(SSLContext sslcontext) {
		// 服务器验证策略使用DNS域名解析
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());

		// Create a registry of custom connection socket factories for supported
		// protocol schemes.
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", sslsf)
				.build();
		
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		connManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
		connManager.setDefaultMaxPerRoute(MAX_PER_ROUTE);
		connManager.setValidateAfterInactivity(AFTER_INACTIVITY);
		
		return connManager;
	}
	
	/**
	 * getSSLHttpClient:获取默认的SSL,不携带客户端证书<br/>
	 * 
	 * @author chengyun.quan@cimc.com
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public static CloseableHttpClient getSSLHttpClient() throws Exception {
		return getSSLHttpClient("", "");
	}

	/**
	 * getSSLHttpClient:client/server certification<br/>
	 * 
	 * @param path
	 * @param password
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	public static CloseableHttpClient getSSLHttpClient(String path, String password) throws Exception {
		KeyStoreMaterial keyStore = null;
		if(StringUtils.isNotEmpty(path) && !StringUtils.isNotEmpty(password)){
			keyStore = KeyStoreUtil.getKeyStore(path, password);
		}
		return getSSLHttpClient(keyStore);
	}

	/**
	 * getSSLHttpClient:根据keyStore获取一个httpclient <br/>
	 * 
	 * @param keyStore
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	private static CloseableHttpClient getSSLHttpClient(KeyStoreMaterial keyStore) throws Exception {
		PoolingHttpClientConnectionManager connManager = getSSLConnManager(keyStore);
		if (connManager == null) {
			return null;
		}
		return HttpClients.custom().setConnectionManager(connManager).build();
	}

}
