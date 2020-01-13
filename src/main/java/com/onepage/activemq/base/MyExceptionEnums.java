package com.onepage.activemq.base;

import java.sql.Date;

public enum MyExceptionEnums implements MyException {

	ERROR01(001, "XX错误", new Date(System.currentTimeMillis()));

	private Integer code;
	private String message;
	private Date date;

	MyExceptionEnums(Integer code, String message, Date date) {
		this.code = code;
		this.message = message;
		this.date = date;

	}



	public MyRunException toException(Object... args) {
		return new MyRunException(this,args);
	}



	@Override
	public Integer getCode() {
		// TODO Auto-generated method stub
		return this.code;
	}



	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}



	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return this.date;
	}
}
