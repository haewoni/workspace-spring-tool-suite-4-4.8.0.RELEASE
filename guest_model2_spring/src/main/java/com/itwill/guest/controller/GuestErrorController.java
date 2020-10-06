package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.itwill.summer.Controller;

public class GuestErrorController implements org.springframework.web.servlet.mvc.Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
									  HttpServletResponse response) {
		/**************************************************/
		String forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		ModelAndView mv=new ModelAndView();
		mv.setViewName(forwardPath);
		return mv;
	}

}
