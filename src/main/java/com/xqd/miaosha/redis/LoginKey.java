package com.xqd.miaosha.redis;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
public class LoginKey extends BasePrefix{

	private LoginKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
	public static LoginKey loginCount = new LoginKey(0, "LoginKey");
	public static LoginKey RegisterVerifyCode = new LoginKey(300, "rvc");
}
