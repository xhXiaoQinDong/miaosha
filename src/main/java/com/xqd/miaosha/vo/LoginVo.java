package com.xqd.miaosha.vo;

import javax.validation.constraints.NotNull;

import com.xqd.miaosha.validator.IsMobile;
import org.hibernate.validator.constraints.Length;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
public class LoginVo {
	
	@NotNull
	@IsMobile
	private String mobile;
	
	@NotNull
	@Length(min=32)
	private String password;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginVo [mobile=" + mobile + ", password=" + password + "]";
	}
}
