package com.onepage.activemq.base;

import java.sql.Date;



public class ResultUtils {
public static <T> Result<T> fail(Integer code,String message,Date date){
	Result<T> result =new Result<T>();
	result.setCode(code);
	result.setMessage(message);
	result.setDate(date);
	return result;
}
}
