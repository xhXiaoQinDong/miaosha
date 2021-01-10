package com.xqd.miaosha.exception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xqd.miaosha.config.returnInfo.CodeMsg;
import com.xqd.miaosha.config.returnInfo.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 雪浪风尘
 * @Remember Keep thinking
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
		if (e instanceof GlobalException) {
			GlobalException ex=(GlobalException)e;
			return Result.error(ex.getCm());
		} else if (e instanceof BindException){
			BindException ex=(BindException)e;
			List<ObjectError> errors= ex.getAllErrors();
			ObjectError error = errors.get(0);

			String msg=error.getDefaultMessage();
			return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
		}else {
			return Result.error(CodeMsg.SERVER_ERROR);
		}
	}
}
