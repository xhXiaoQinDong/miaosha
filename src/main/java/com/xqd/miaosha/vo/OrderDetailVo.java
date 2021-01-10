package com.xqd.miaosha.vo;

import com.xqd.miaosha.domain.OrderInfo;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
public class OrderDetailVo {
	private GoodsVo goods;
	private OrderInfo order;
	public GoodsVo getGoods() {
		return goods;
	}
	public void setGoods(GoodsVo goods) {
		this.goods = goods;
	}
	public OrderInfo getOrder() {
		return order;
	}
	public void setOrder(OrderInfo order) {
		this.order = order;
	}
}
