package com.example.demo.common.util;

import java.security.SecureRandom;

/**
 * @Description： 安全随机数生成工具类
 */
public class SecureRandomUtil {
	private static volatile SecureRandom secureRandom;
	public static SecureRandom getSecureRandom() {
		if(null == secureRandom){
			synchronized (SecureRandomUtil.class) {
				if(null == secureRandom){
					try {
						secureRandom = SecureRandom.getInstance("SHA1PRNG","SUN");
					} catch (Exception e) {
						e.printStackTrace();
						System.err.println("Get SecureRandom instance exception:"+e.getMessage());
						throw new RuntimeException("Get SecureRandom instance exception:"+e.getMessage());
					}
				}
			}
		}
		return secureRandom;
	}
}
