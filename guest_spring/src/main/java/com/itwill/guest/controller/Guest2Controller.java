package com.itwill.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.guest.GuestService;

public class Guest2Controller {
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value="guest_modify_action.do")
	public String guest_modify_action_get() {
		return "redirect:guest_modify_form.do";
	}
	
	public String guest_modi

}
