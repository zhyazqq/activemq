package com.onepage.activemq.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> extends MyErrorMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4300890754164025214L;

private T data;

}
