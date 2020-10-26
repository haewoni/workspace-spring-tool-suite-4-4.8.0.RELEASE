package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestResultList;
import com.itwill.guest.GuestService;

@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;
	@RequestMapping(value = "guest_list_xml",produces = "text/xml;charset=UTF-8")
	public GuestResultList guest_list_xml() throws Exception{
		GuestResultList guestResultList=new GuestResultList();
		List<Guest> guestList=guestService.selectAll();
		guestResultList.setGuestList(guestList);
		return guestResultList;
		/*
		<guest_list>
			<guest>
				<guest_no>11</guest_no>
				<guest_name>df</guest_name>
				<guest_date>2020-10-26 15:40:20</guest_date>
				<guest_email>df</guest_email>
				<guest_homepage>df</guest_homepage>
				<guest_title>dfg</guest_title>
				<guest_content>df</guest_content>
			</guest>
		<guest_list>	
		 */
		
		
	}
	
	@RequestMapping(value = "guest_list_json",produces = "application/json;charset=UTF-8")
	public List<Guest> guest_list_json() throws Exception{
		return guestService.selectAll();
	}
	@RequestMapping(value = "guest_list_html", produces = "text/html;charset=UTF-8")
	public String guest_list_html() throws Exception{
		StringBuffer htmlSb = new StringBuffer();
		List<Guest> guestList = (List<Guest>) guestService.selectAll();
		for (Guest guest : guestList) {
			htmlSb.append("<div class=\"guest_item\">");
			htmlSb.append("<h3 class=\"guest_title\"  guest_no=\"" + guest.getGuest_no() + "\"><a href=\"\">"
					+ guest.getGuest_title() + "[HTML]</a></h3>");
			htmlSb.append("</div>");
		}
		return htmlSb.toString();
	}
	
	

}
