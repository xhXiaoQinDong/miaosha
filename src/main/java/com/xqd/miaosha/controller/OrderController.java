package com.xqd.miaosha.controller;

import com.xqd.miaosha.config.returnInfo.CodeMsg;
import com.xqd.miaosha.config.returnInfo.Result;
import com.xqd.miaosha.domain.MiaoshaUser;
import com.xqd.miaosha.domain.OrderInfo;
import com.xqd.miaosha.redis.RedisService;
import com.xqd.miaosha.service.GoodsService;
import com.xqd.miaosha.service.MiaoshaUserService;
import com.xqd.miaosha.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xqd.miaosha.vo.GoodsVo;
import com.xqd.miaosha.vo.OrderDetailVo;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
    MiaoshaUserService userService;

	@Autowired
    RedisService redisService;

	@Autowired
    OrderService orderService;

	@Autowired
    GoodsService goodsService;

    @RequestMapping("/detail")
    @ResponseBody
    public Result<OrderDetailVo> info(Model model, MiaoshaUser user,
									  @RequestParam("orderId") long orderId) {
    	if(user == null) {
    		return Result.error(CodeMsg.SESSION_ERROR);
    	}
    	OrderInfo order = orderService.getOrderById(orderId);
    	if(order == null) {
    		return Result.error(CodeMsg.ORDER_NOT_EXIST);
    	}
    	long goodsId = order.getGoodsId();
    	GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
    	OrderDetailVo vo = new OrderDetailVo();
    	vo.setOrder(order);
    	vo.setGoods(goods);
    	return Result.success(vo);
    }

}
