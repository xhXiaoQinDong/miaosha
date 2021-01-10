package com.xqd.miaosha.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.xqd.miaosha.config.returnInfo.CodeMsg;
import com.xqd.miaosha.domain.MiaoshaUser;
import com.xqd.miaosha.domain.User;
import com.xqd.miaosha.exception.GlobalException;
import com.xqd.miaosha.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xqd.miaosha.dao.MiaoshaUserDao;
import com.xqd.miaosha.redis.MiaoshaUserKey;
import com.xqd.miaosha.util.MD5Util;
import com.xqd.miaosha.util.UUIDUtil;
import com.xqd.miaosha.vo.LoginVo;

import java.util.Date;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
@Service
public class MiaoshaUserService {
	
	
	public static final String COOKIE_NAME_TOKEN = "token";
	
	@Autowired
	MiaoshaUserDao miaoshaUserDao;
	
	@Autowired
	RedisService redisService;
	
	public MiaoshaUser getById(long id) {
		//取缓存
		MiaoshaUser user = redisService.get(MiaoshaUserKey.getById, ""+id, MiaoshaUser.class);
		if(user != null) {
			return user;
		}
		//取数据库
		user = miaoshaUserDao.getById(id);
		if(user != null) {
			redisService.set(MiaoshaUserKey.getById, ""+id, user);
		}
		return user;
	}

	public MiaoshaUser getByToken(HttpServletResponse response, String token) {
		if(StringUtils.isEmpty(token)) {
			return null;
		}
		MiaoshaUser user = redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
		//延长有效期
		if(user != null) {
			addCookie(response, token, user);
		}
		return user;
	}
	

	public String login(HttpServletResponse response, LoginVo loginVo) {
		if(loginVo == null) {
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		String mobile = loginVo.getMobile();
		String formPass = loginVo.getPassword();
		//判断手机号是否存在
		MiaoshaUser user = getById(Long.parseLong(mobile));
		if(user == null) {
			throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
		}
		//验证密码
		String dbPass = user.getPassword();
		String saltDB = user.getSalt();
		String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
		if(!calcPass.equals(dbPass)) {
			throw new GlobalException(CodeMsg.PASSWORD_ERROR);
		}
		//生成cookie
		String token	 = UUIDUtil.uuid();
		addCookie(response, token, user);
		return token;
	}
	
	private void addCookie(HttpServletResponse response, String token, MiaoshaUser user) {
		redisService.set(MiaoshaUserKey.token, token, user);
		Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
		cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public void register(HttpServletResponse response, String userName, String passWord, String salt) {
		//先判断用户名是否已存在
		User user = miaoshaUserDao.selectByUserName(userName);
		if (user!=null){
			throw new GlobalException(CodeMsg.USER_EXIST);
		}
		User insertUser =  new User();
		insertUser.setUsername(userName);
		String DBPassWord =  MD5Util.formPassToDBPass(passWord , salt);
		insertUser.setPassword(DBPassWord);
		insertUser.setRegisterDate(new Date());
		insertUser.setSalt(salt);
		boolean insert= miaoshaUserDao.insertMiaoShaUser(insertUser);
		if (insert==false){
			throw new GlobalException(CodeMsg.REGISTER_FAIL);
		}
	}
}
