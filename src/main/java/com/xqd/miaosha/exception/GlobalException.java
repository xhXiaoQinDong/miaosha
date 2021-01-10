package com.xqd.miaosha.exception;

import com.xqd.miaosha.config.returnInfo.CodeMsg;

import java.io.Serializable;


/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
public class GlobalException extends RuntimeException{
	private static final long serialVersionUID=1L;
	private CodeMsg cm;

	public GlobalException(CodeMsg cm){
		super(cm.toString());
		this.cm=cm;
	}

	public CodeMsg getCm() {
		return cm;
	}

}
