package com.onepage.activemq.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onepage.activemq.base.MyExceptionEnums;
import com.onepage.activemq.base.MyRunException;
import com.onepage.activemq.service.DemoService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/active")
public class DoItController {
	@Resource
	private DemoService service;
	
	public String doIt() {
		service.doIt();
		
		return "success";
	}
	@RequestMapping("/demo")
	public String  demo() {
		System.out.println("haaaa");
//		return "hah";
		throw new MyRunException(MyExceptionEnums.ERROR01);
	}
}
