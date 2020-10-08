package com.itwill.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;

	@RequestMapping("guest_modify_action.do")
	public String guest_modify_action_post(@ModelAttribute Guest guest) throws Exception {
		String forwardPath = "";
		guestService.updateGuest(guest);
		forwardPath = "redirect:guest_list.do";
		return forwardPath;
	}

	@RequestMapping("guest_modify_form.do")
	public String guest_modify_form() {
		return "guest_modify_form";
	}

	@RequestMapping(value = "/guest_write_action.do", method = RequestMethod.GET)
	public String guest_write_action_get() {
		return "redirect:guest_write_form.do";
	}

	@RequestMapping(value = "/guest_write_action.do", method = RequestMethod.POST)
	public String guest_write_action_post(@ModelAttribute Guest guest) throws Exception {
		String forwardPath = "";
		int insertRowCount = guestService.insertGuest(guest);
		forwardPath = "redirect:guest_list.do";
		return forwardPath;
	}

	@RequestMapping("/guest_write_form.do")
	public String guest_write_form() {
		return "guest_write_form";
	}

	@RequestMapping("/guest_main.do")
	public String guest_main() {
		return "guest_main";
	}

	@RequestMapping("/guest_list.do")
	public String guest_list(Model model) throws Exception {
		String forwardPath = "";
		List<Guest> guestList = guestService.selectAll();
		model.addAttribute("guestList", guestList);
		forwardPath = "guest_list";
		return forwardPath;
	}

	@RequestMapping("/guest_view.do")
	public String guest_view(Model model, @RequestParam String guest_no) throws Exception {
		String forwardPath = "";
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_no));
		model.addAttribute("guest", guest);
		forwardPath = "guest_view";
		return forwardPath;
	}

	@ExceptionHandler(Exception.class)
	public String guest_error_handle(Exception e) {
		return "guest_error";
	}

}
