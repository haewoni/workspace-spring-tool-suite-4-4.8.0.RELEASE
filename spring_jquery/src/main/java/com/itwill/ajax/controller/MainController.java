package com.itwill.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping(value = "02.ajaxRequestJSP")
	public String ajaxRequest() {
		return "02.ajaxRequest";
	}
}
