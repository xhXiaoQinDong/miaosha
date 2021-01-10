package com.xqd.miaosha.redis;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
public class UserKey extends BasePrefix{

	private UserKey(String prefix) {
		super(prefix);
	}
	public static UserKey getById = new UserKey("id");
	public static UserKey getByName = new UserKey("name");
}
