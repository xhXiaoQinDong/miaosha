package com.xqd.miaosha.controller;

import com.xqd.miaosha.config.returnInfo.CodeMsg;
import com.xqd.miaosha.config.returnInfo.Result;
import com.xqd.miaosha.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    MiaoshaUserService miaoshaUserService;
    @RequestMapping("/to_register")
    public String index(){
        return "register";
    }

    @RequestMapping("/register")
    @ResponseBody
    public Result<CodeMsg> register(@RequestParam("username") String userName ,
                                    @RequestParam("password") String passWord,
                                    @RequestParam("salt") String salt, HttpServletResponse response ){

        miaoshaUserService.register(response , userName,passWord,salt);
        return Result.success( CodeMsg.SUCCESS);
    }
}
