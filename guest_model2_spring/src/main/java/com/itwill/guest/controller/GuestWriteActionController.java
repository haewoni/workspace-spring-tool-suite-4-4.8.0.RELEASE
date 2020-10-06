package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;

public class GuestWriteActionController implements Controller {
	private GuestService guestService;
	public GuestWriteActionController() {
		// TODO Auto-generated constructor stub
	}

	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/********************guest_write_action.do******************/
		ModelAndView mv= new ModelAndView();
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath = "redirect:guest_main.do";
		}else {
			String guest_name = request.getParameter("guest_name");
			String guest_email = request.getParameter("guest_email");
			String guest_homepage = request.getParameter("guest_homepage");
			String guest_title = request.getParameter("guest_title");
			String guest_content = request.getParameter("guest_content");
			try {
				int insertRowCount = guestService
						.insertGuest(new Guest(0, guest_name, "", guest_email, guest_homepage, guest_title, guest_content));
				forwardPath="redirect:guest_list.do";
			}catch (Exception e) {
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				e.printStackTrace();
			}
		}
		mv.setViewName(forwardPath);
		return mv;
	}

}
