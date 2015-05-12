package com.pczhu.utils;

import java.security.MessageDigest;

public class MD5Utils {
	public static String toMD5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 16位的加密，其实就是32位加密后的截取
			return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
