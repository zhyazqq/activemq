package com.onepage.activemq.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onepage.activemq.service.DemoService;

@RestController
@RequestMapping("/active")
public class DoItController {
	@Resource
	private DemoService service;
	@RequestMapping("/demo")
	public String doIt() {
		service.doIt();
		return "success";
	}
}
