package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReponseController {
	/********************forward view*******************/
	@RequestMapping("/response_view_name.do")
	public String response_view_name() {
		/* 
		 << 빈의 이름에 forward:가 없을 경우 >>
		 
		  0 . view name[String(/WEB-INF/views/response_view_name.jsp)]을 반환받은 
		      DispatcherServlet은 InternalResourceViewResolver객체(디폴트)에 view name을 전달한다.
		  1 . InternalResourceViewResolver 객체는 InternalResourceView 객체를 생성한다. 
		  2 . InternalResourceViewResolver 객체는 
		      InternalResourceView 객체에 view name(/WEB-INF/views/response_view_name.jsp)을
		      URL로 설정한후에 DispatcherServlet에게 반환한다.
		      (설정에 prefix,suffix가 설정된다)
		  3 . DispatcherServlet 은 반환받은 InternalResourceView 객체의 render()메쏘드를 호출한다.
		      결과로 /WEB-INF/views/response_view_name.jsp로 forward된다.
		      	
		  << 빈의 이름에 forward: 가 있을 경우 >> 
		      
		  0 . view name[String(forward:/WEB-INF/views/response_view_name.jsp)]을 반환받은 
		      DispatcherServlet은 InternalResourceViewr객체(디폴트)에 view name을 전달한다.
		  1 . InternalResourceViewResolver 객체는 InternalResourceView 객체를 생성한다. 
		  2 . InternalResourceViewResolver 객체는 
		      InternalResourceView 객체에 view name(/WEB-INF/views/response_view_name.jsp)을
		      URL로 설정한후에 DispatcherServlet에게 반환한다.
		      (prefix,suffix가 설정되지 않는다)
		  3 . DispatcherServlet 은 반환받은 InternalResourceView 객체의 render()메쏘드를 호출한다.
		      결과로 /WEB-INF/views/response_view_name.jsp로 forward된다.     
		      
		*/
		/*
		/*
		mcv-config-view-resolver.xml
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<property name="prefix" value="/WEB-INF/views/"/>
			<property name="suffix" value=".jsp"/>
		</bean>
		 */
		return "forward:/WEB-INF/views/response_view_name.jsp";
	}
	@RequestMapping("/response_view_object.do")
	public View response_view_object() {
		InternalResourceView internalResourceView = new InternalResourceView();
		internalResourceView.setUrl("/WEB-INF/views/response_view_object.jsp");   //forward 붙이면 안됨
		return internalResourceView;
		//String --> forward:/WEB-INF/views/response_view_object/jsp
		/*
		 * 1. internalResourceView.setUrl("/WEB-INF/views/response_view_object/jsp") 반환
		 * 2. URL --> /WEB-INF/views/response_view_object/jsp forward
		 */
	}
	/********************redirect view*******************/
	@RequestMapping("response_redirect_view_name.do")
	public String response_redirect_view_name(Model model) {
		model.addAttribute("id","guard");
		model.addAttribute("name","kim");
		return "redirect:response_redirect_view_name.jsp";
	}
	@RequestMapping("response_redirect_view_object.do")
	public View response_redirect_view_object(Model model) {
		model.addAttribute("id", "guard");
		model.addAttribute("name", "kim");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("response_redirect_view_object.jsp");
		/*
		 * response_redirect_view_object.jsp?id=guard&name=kim
		 */
		return redirectView;
	}
	
	
}