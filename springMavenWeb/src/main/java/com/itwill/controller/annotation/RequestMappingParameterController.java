package com.itwill.controller.annotation;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.Guest;

@Controller
public class RequestMappingParameterController {
	@RequestMapping("/parameter_guest_write_form.do")
	public String parameter_guest_write_form() {
		
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	
	@RequestMapping(value="/parameter_guest_write_action.do",
			method=RequestMethod.GET)	
	public String parameter_guest_write_action_get() {
//		return "redirect:parameter_guest_write_form.do";
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	
	@RequestMapping(value="/parameter_guest_write_action.do",
					method=RequestMethod.POST)					
	public String parameter_guest_write_action(
				@RequestParam("guest_name") String name,
				@RequestParam String guest_title,
				@RequestParam String guest_email,
				@RequestParam String guest_homepage,
				@RequestParam String guest_content) throws Exception {
		
//		name=new String(name.getBytes("8859_1"),"UTF-8"); //String 으로 객체 생성해서 깨지는 문자 복원
		
		Guest guest=
				new Guest(0, name, null, 
						guest_email, guest_homepage,
						guest_title, guest_content);
		System.out.println("Guest Parameter:"+guest);
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
	
	@RequestMapping(value="/model_attribute_guest_write_action.do",
					method=RequestMethod.POST)	
	public String model_attribute_guest_write_action(@ModelAttribute Guest guest) {
		System.out.println("### @ModelAttribute Guest:"+guest);
		 /*
		 * 1. 파라메타의 모든 객체 받기
		 * 2. 선언된 DTO 객체[Guest]생성 (기본생성자)
		 * 3. 받은 파라메타 데이타를 파라메타 이름과 일치하는
		 *    Guest객체의 속성메쏘드(setter method) 호출해서 대입
		 * 4. Guest 클래스 이름 첫 글자를 소문자로 변경한 이름(guest)으로
		 *    request객체에 속성(attribute)등록
		 *    request.setAttribute("guest",guest);
		 */
		/*
		 * GuestService메쏘드호출
		 */
		this.guestList();
		/*
		 ArrayList<Guest> guestList = this.guestList();
		 */
		return "forward:/WEB-INF/views/guest_wirte_result.jsp";
	}
	private @ModelAttribute ArrayList<Guest> guestList() {
		ArrayList<Guest> guestList =new ArrayList<Guest>();
		guestList.add(new  Guest());
		guestList.add(new  Guest());
		guestList.add(new  Guest());
		guestList.add(new  Guest());
		guestList.add(new  Guest());
		guestList.add(new  Guest());
		return guestList;
	}
}
