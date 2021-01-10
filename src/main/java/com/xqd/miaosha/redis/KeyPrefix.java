package com.xqd.miaosha.redis;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
public interface KeyPrefix {
		
	public int expireSeconds();
	
	public String getPrefix();
	
}
