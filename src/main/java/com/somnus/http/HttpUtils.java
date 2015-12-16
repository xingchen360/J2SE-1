package com.somnus.http;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/** 
 * @Description: HTTP（HTTPS）接口方式，工具类
 * @author Somnus
 * @date 2015年12月16日 下午4:37:59 
 * @version V1.0 
 */
public class HttpUtils {

    /**
     * 获取https连接
     * 
     * @param uri
     *            请求地址
     * @param cerServerFile
     *            服务端CA认证文件
     * @param cerServerPwd
     *            服务端CA认证文件密码
     * @param cerClientFile
     *            客户端CA认证文件
     * @param cerClientPwd
     *            客户端CA认证文件密码
     * @return
     * @throws Exception
     */
    public static HttpsURLConnection getHttpsConnection(String uri, String cerServerFile, String cerServerPwd,
            String cerClientFile, String cerClientPwd) throws Exception {
        @SuppressWarnings("restriction")
        URL url = new URL(null, uri, new sun.net.www.protocol.https.Handler());
        // 解决 HTTPS hostname wrong: should be <localhost>
        System.setProperty("java.protocol.handler.pkgs", "javax.net.ssl");
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                return urlHostName.equals(session.getPeerHost());
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(getSSLSocketFactory(cerServerFile, cerServerPwd, cerClientFile, cerClientPwd));
        connection.setRequestMethod("POST");
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("Content-Type", "text/html");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        return connection;
    }

    /**
     * 获取http连接
     * 
     * @param uri
     *            请求地址
     * @return
     * @throws Exception
     */
    public static HttpURLConnection getHttpConnection(String uri) throws Exception {
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");

        return connection;
    }

    /**
     * 私有方法
     * @param cerServerFile
     * @param cerServerPwd
     * @param cerClientFile
     * @param cerClientPwd
     * @return
     * @throws Exception
     */
    private static SSLSocketFactory getSSLSocketFactory(String cerServerFile, String cerServerPwd,
            String cerClientFile, String cerClientPwd) throws Exception {
        SysKeyManager keyManager = new SysKeyManager(SysKeyStoreUtil.KeyStoreType.PKCS12, cerClientFile, cerClientPwd.toCharArray());
        SysTrustManager trustManager = new SysTrustManager(cerServerFile, cerServerPwd.toCharArray());
        SysSSLContext context = new SysSSLContext("TLS", keyManager, trustManager);
        return context.getSSLContext().getSocketFactory();
    }
    
    private static class SysKeyManager {

        private KeyStore ks;
        private char[] password;

        /**
         * @param keyStore 
         * @param password 
         * @throws Exception 
         */
        @SuppressWarnings("unused")
        public SysKeyManager(String keyStore, char[] password) throws Exception {
            this(SysKeyStoreUtil.KeyStoreType.JKS, keyStore, password);
        }

        /**
         * 
         * @param type 
         * @param keyStore 
         * @param password 
         * @throws Exception 
         */
        public SysKeyManager(SysKeyStoreUtil.KeyStoreType type, String keyStore, char[] password) throws Exception {
            this.password = password;
            this.ks = SysKeyStoreUtil.loadKeyStore(type, keyStore, password);
        }

        public KeyManager[] getKeyManagers() throws Exception {
            try {
                KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
                kmf.init(ks, password);
                return kmf.getKeyManagers();
            } catch (Exception e) {
                throw e;
            }
        }
    }
    
    private static class SysKeyStoreUtil {

        private SysKeyStoreUtil() {}

        public static KeyStore loadKeyStore(KeyStoreType type, String keyStore, char[] password) throws Exception {
            KeyStoreType type2 = type;
            if (type2 == null) {
                type2 = KeyStoreType.JKS;
            }
            InputStream in = null;
            try {
                try {
                    KeyStore ks = type2.getKeyStore();
                    if(keyStore.startsWith("/") || keyStore.indexOf(":") > 0){
                        //绝对路径
                        in = new FileInputStream(keyStore);
                    }else{
                        //相对项目根目录的路径
                        in = SysKeyStoreUtil.class.getClassLoader().getResourceAsStream(keyStore);
                    }
                    ks.load(in, password);
                    return ks;
                } finally {
                    if (in != null) {
                        in.close();
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }

        public static enum KeyStoreType {
            JKS {
                @Override
                public KeyStore getKeyStore() throws KeyStoreException {
                    return super.getKeyStore("JKS");
                }
            },

            PKCS12 {
                @Override
                public KeyStore getKeyStore() throws KeyStoreException {
                    return super.getKeyStore("PKCS12");
                }
            };

            public abstract KeyStore getKeyStore() throws KeyStoreException ;

            private static KeyStore getKeyStore(String type) throws KeyStoreException {
                return KeyStore.getInstance(type);
            }
           
        }
    }
    
    private static class SysSSLContext {

        private String protocol;
        private SysKeyManager keyManager;
        private SysTrustManager trustManager;

        /**
         * @param protocol 
         * @param keyManager 
         * @param trustManager 
         */
        public SysSSLContext(String protocol, SysKeyManager keyManager, SysTrustManager trustManager) {
            this.protocol = protocol;
            this.keyManager = keyManager;
            this.trustManager = trustManager;
        }

        /**
         * @param protocol 
         * @param trustManager 
         */
        @SuppressWarnings("unused")
        public SysSSLContext(String protocol, SysTrustManager trustManager) {
            this(protocol, null, trustManager);
        }

        /**
         * @param protocol 
         * @param keyManager 
         */
        @SuppressWarnings("unused")
        public SysSSLContext(String protocol, SysKeyManager keyManager) {
            this(protocol, keyManager, null);
        }

        public SSLContext getSSLContext() {
            try {
                SSLContext context = SSLContext.getInstance(protocol);
                context.init(getKeyManagers(), getTrustManagers(), null);
                return context;
            } catch (Exception e) {
                throw new IllegalStateException("error, protocol: " + protocol, e);
            }
        }

        private KeyManager[] getKeyManagers() throws Exception {
            if (keyManager == null) {
                return null;
            }
            return keyManager.getKeyManagers();
        }

        private TrustManager[] getTrustManagers() throws Exception {
            if (trustManager == null) {
                return null;
            }
            return trustManager.getTrustManagers();
        }
    }
    
    private static class SysTrustManager {

        private KeyStore ks;

        /**
         * @param keyStore
         * @param password
         * @throws Exception
         */
        public SysTrustManager(String keyStore, char[] password) throws Exception {
            this(SysKeyStoreUtil.KeyStoreType.JKS, keyStore, password);
        }

        /**
         * @param type
         * @param keyStore
         * @param password
         * @throws Exception
         */
        public SysTrustManager(SysKeyStoreUtil.KeyStoreType type, String keyStore, char[] password) throws Exception {
            this.ks = SysKeyStoreUtil.loadKeyStore(type, keyStore, password);
        }

        public TrustManager[] getTrustManagers() throws Exception {
            return new TrustManager[] { new ClientTrustManager() };
        }

        private class ClientTrustManager implements X509TrustManager {
            private X509TrustManager sunJSSEX509TrustManager;

            public ClientTrustManager() throws Exception {
                loadTrust();
            }

            private void loadTrust() throws Exception {
                try {
                    TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    tmf.init(ks);
                    TrustManager[] tms = tmf.getTrustManagers();
                    for (int i = 0; i < tms.length; i++) {
                        if (tms[i] instanceof X509TrustManager) {
                            sunJSSEX509TrustManager = (X509TrustManager) tms[i];
                            return;
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            }

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                sunJSSEX509TrustManager.checkClientTrusted(chain, authType);
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                sunJSSEX509TrustManager.checkServerTrusted(chain, authType);
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return sunJSSEX509TrustManager.getAcceptedIssuers();
            }
        }
    }
}
