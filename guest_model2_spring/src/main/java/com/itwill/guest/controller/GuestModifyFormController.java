package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;
import com.itwill.summer.Controller;

public class GuestModifyFormController implements org.springframework.web.servlet.mvc.Controller {
	private GuestService guestService;
	public GuestModifyFormController() {
	}
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/********************guest_modify_form.do******************/
		ModelAndView mv = new ModelAndView();
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:guest_main.do";
		}else {
			try {
				String guest_noStr = request.getParameter("guest_no");
				Guest guest=
						guestService.selectByNo(Integer.parseInt(guest_noStr));
				request.setAttribute("guest", guest);
				forwardPath="forward:/WEB-INF/views/guest_modify_form.jsp";
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}
		mv.setViewName(forwardPath);
		return mv;
	}

}
