package com.onepage.activemq.base;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyErrorMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5753943945739159259L;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer code;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date date;

}
