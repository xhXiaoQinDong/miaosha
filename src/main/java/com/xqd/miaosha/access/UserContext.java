package com.xqd.miaosha.access;

import com.xqd.miaosha.domain.MiaoshaUser;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
public class UserContext {
	
	private static ThreadLocal<MiaoshaUser> userHolder = new ThreadLocal<MiaoshaUser>();
	
	public static void setUser(MiaoshaUser user) {
		userHolder.set(user);
	}
	
	public static MiaoshaUser getUser() {
		return userHolder.get();
	}

}
