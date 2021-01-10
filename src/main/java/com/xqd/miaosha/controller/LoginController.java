package com.xqd.miaosha.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.xqd.miaosha.config.returnInfo.Result;
import com.xqd.miaosha.redis.LoginKey;
import com.xqd.miaosha.redis.RedisService;
import com.xqd.miaosha.service.MiaoshaUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xqd.miaosha.vo.LoginVo;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
@Controller
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
    MiaoshaUserService userService;
	
	@Autowired
    RedisService redisService;
    @RequestMapping("")
    public String index(Model model){
        Long count = redisService.incr(LoginKey.loginCount, "loginCount");
        model.addAttribute("count",count);
        return "login";
    }
    @RequestMapping("/index")
    public String indexBack(){
        return "login";
    }
    @RequestMapping("/do_login")
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo, Model model) {
    	log.info(loginVo.toString());
    	//登录
    	String token = userService.login(response, loginVo);
    	return Result.success(token);
    }
}
