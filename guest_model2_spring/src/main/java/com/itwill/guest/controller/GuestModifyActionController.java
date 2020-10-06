package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;
import com.itwill.summer.Controller;

public class GuestModifyActionController implements org.springframework.web.servlet.mvc.Controller {
	
	private GuestService guestService;
	public GuestModifyActionController() {
		System.out.println("### GuestModifyActionController: 기본생성자호출");
	}
	
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
		System.out.println("### GuestModifyActionController: setGuestService("+guestService+")메소드 호출");
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/******************guest_modify_action.do******************/
		ModelAndView mv = new ModelAndView();
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:guest_main.do";
		}else {
			try{
				//request.setCharacterEncoding("UTF-8");
				String guest_noStr=request.getParameter("guest_no");
				String guest_name=request.getParameter("guest_name");
				String guest_email=request.getParameter("guest_email");
				String guest_homepage=request.getParameter("guest_homepage");
				String guest_title=request.getParameter("guest_title");
				String guest_content=request.getParameter("guest_content");
				int updateRowCount=
						guestService.updateGuest(
									new Guest(Integer.parseInt(guest_noStr),
										guest_name,null,
										guest_email,guest_homepage,
										guest_title,guest_content));
				forwardPath="redirect:guest_view.do?guest_no="+guest_noStr;
				//forwardPath="forward:guest_view.do";
			}catch(Exception e){
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}
		mv.setViewName(forwardPath);
		return mv;
	}

}
