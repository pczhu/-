package com.pczhu.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPUtils {

	public static String getIP() {
		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		return ip.getHostAddress();
	}

	public static String getLocalIP() {
		return "192.168.0.101:8080";
	}


}
