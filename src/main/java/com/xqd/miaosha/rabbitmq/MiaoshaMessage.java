package com.xqd.miaosha.rabbitmq;

import com.xqd.miaosha.domain.MiaoshaUser;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
public class MiaoshaMessage {
	private MiaoshaUser user;
	private long goodsId;
	public MiaoshaUser getUser() {
		return user;
	}
	public void setUser(MiaoshaUser user) {
		this.user = user;
	}
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
}
