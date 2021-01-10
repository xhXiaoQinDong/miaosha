package com.xqd.miaosha.redis;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
public class OrderKey extends BasePrefix {

	public OrderKey(String prefix) {
		super(prefix);
	}
	public static OrderKey getMiaoshaOrderByUidGid = new OrderKey("moug");
}
