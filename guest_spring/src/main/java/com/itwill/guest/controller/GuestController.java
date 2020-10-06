package com.itwill.guest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	//@Autowired
	//private GuestService guestService;
	
	@RequestMapping("/guest_error.do")
	public String guest_error() {
		return "forward:/WEB-INF/views/guest_error.jsp";
	}
	@RequestMapping("/guest_list.do")
	public ArrayList<Guest> guest_list() {
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		guestList.add(new Guest());
		return guestList;
	}
	@RequestMapping(value="/guest_modify_form.do",
					method=RequestMethod.POST)
	public String guest_modify_form(@ModelAttribute Guest guest) {
		return "forward:/WEB-INF/views/guest_modify_form.jsp";
	}
	@RequestMapping("/guest_view_form.do")
	public String guest_view_form() {
		return "forward:/WEB-INF/views/guest_view_form.jsp";
	}
	@RequestMapping("/guest_main_form.do")
	public String guest_main_form() {
		return "forward:/WEB-INF/views/guest_main_form.jsp";
	}
	@RequestMapping("/guest_write_form.do")
	public String guest_write_form() {
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}

}
