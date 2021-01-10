package com.xqd.miaosha.controller;

import com.xqd.miaosha.config.returnInfo.Result;
import com.xqd.miaosha.domain.MiaoshaUser;
import com.xqd.miaosha.redis.RedisService;
import com.xqd.miaosha.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
    MiaoshaUserService userService;
	
	@Autowired
    RedisService redisService;
	
    @RequestMapping("/info")
    @ResponseBody
    public Result<MiaoshaUser> info(Model model, MiaoshaUser user) {
        return Result.success(user);
    }
    
}
