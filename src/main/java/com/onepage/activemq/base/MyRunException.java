package com.onepage.activemq.base;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class MyRunException extends RuntimeException implements MyError,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2123084690290455649L;

	private MyErrorMessage myErrorMessage;

	public MyRunException() {
		super();
	}

	public MyRunException(MyException myException) {
		super("[" +myException.getCode()+"]"+myException.getMessage()+"--->time----->"+myException.getDate());
		myErrorMessage = new MyErrorMessage(myException.getCode(), myException.getMessage(), myException.getDate());
	}

	public MyRunException(MyException myException, String message) {
		super("[" +myException.getCode()+"]"+message+"--->time----->"+myException.getDate());
		myErrorMessage = new MyErrorMessage(myException.getCode(), message, myException.getDate());
	}

	public MyRunException(MyException myException, Date date) {
		super("[" +myException.getCode()+"]"+myException.getMessage()+"--->time----->"+date);
		myErrorMessage = new MyErrorMessage(myException.getCode(), myException.getMessage(), date);
	}

	public MyRunException(MyException myException, Object... args) {
		super("[" +myException.getCode()+"]"+(args != null && args.length > 0 ? String.format(myException.getMessage(), args) : myException.getMessage())+"--->time----->"+(args != null && args.length > 0 ? DataFormat(myException, args) : myException.getDate()));
		myErrorMessage = new MyErrorMessage(myException.getCode(),
				args != null && args.length > 0 ? String.format(myException.getMessage(), args) : myException.getMessage(),
				args != null && args.length > 0 ? DataFormat(myException, args) : myException.getDate());
	}

	private static Date DataFormat(MyException myException, Object[] args) {
		return myException.getDate();
	}

	public MyRunException(MyException myException, Throwable throwable) {
		super("[" +myException.getCode()+"]"+myException.getMessage()+"--->time----->"+myException.getDate(),throwable);
		myErrorMessage = new MyErrorMessage(myException.getCode(), myException.getMessage(), myException.getDate());
	}

	public MyRunException(MyErrorMessage myErrorMessage) {
		super("[" +myErrorMessage.getCode()+"]"+myErrorMessage.getMessage()+"--->time----->"+myErrorMessage.getDate());	
		this.myErrorMessage = myErrorMessage;
	}

	@Override
	public MyErrorMessage getMyErrorMessage() {
		// TODO Auto-generated method stub
		return myErrorMessage;
	}
}
