package com.xqd.miaosha.domain;

import java.util.Date;
/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
public class MiaoshaUser {
	private Long id;
	private String username;
	private String password;
	private String salt;
	private Date registerDate;

	@Override
	public String toString() {
		return "MiaoshaUser{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", registerDate=" + registerDate +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
}