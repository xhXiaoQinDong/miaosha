package com.xqd.miaosha.util;

import java.util.UUID;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
public class UUIDUtil {
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
