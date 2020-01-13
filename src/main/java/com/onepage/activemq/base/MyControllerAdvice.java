package com.onepage.activemq.base;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyControllerAdvice {
	@ResponseBody
	@ExceptionHandler(value = MyRunException.class)
	public Map<String, Object> exceptionHandler(MyRunException ex) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", ex.getMyErrorMessage().getCode());
		map.put("message", ex.getMyErrorMessage().getMessage());
		map.put("data", ex.getMyErrorMessage().getDate());
		// 发生异常进行日志记录，写入数据库或者其他处理，此处省略
		return map;
	}
}
