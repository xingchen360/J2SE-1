package com.somnus;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 
 * @Description: TODO
 * @author Somnus
 * @date 2016年1月21日 下午2:51:49
 * @version V1.0
 */
public class SystemUtil {

	/**
	 * 获取本机ip地址，并自动区分Windows还是linux操作系统
	 * linux 如若想用InetAddress.getLocalHost()方式获取本机ip，需要保证以下一点
	 * '/etc/hosts'配置中 有一行配置 
	 *                 127.0.0.1 主机名
	 *  centOS主机名在'/etc/sysconfig/network' 配置中可以找到
	 *  Ubuntu主机名在'/etc/network/interfaces' 配置中可以找到
	 *  不然就只能采取现提供的方法
	 * @return String
	 */
	public static String getLocalIP() {
		String sIP = "";
		InetAddress ip = null;
		try {
			// 如果是Windows操作系统
			if (isWindowsOS()) {
				ip = InetAddress.getLocalHost();
			}
			// 如果是Linux操作系统
			else {
				boolean bFindIP = false;
				Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();
				while (netInterfaces.hasMoreElements()) {
					if (bFindIP) {
						break;
					}
					NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
					// 遍历所有ip
					Enumeration<InetAddress> ips = ni.getInetAddresses();
					while (ips.hasMoreElements()) {
						ip = (InetAddress) ips.nextElement();
						// 127.开头的都是lookback地址
						if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() 
								&& ip.getHostAddress().indexOf(":") == -1) {
							bFindIP = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null != ip) {
			sIP = ip.getHostAddress();
		}
		return sIP;
	}

	private static boolean isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		return isWindowsOS;
	}

	public static void main(String[] args) {
		System.out.println(getLocalIP());
	}

}
