package com.itwill.controller.annotation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class SpringModelController {
	@RequestMapping("/model_request.do")
	public String request(HttpServletRequest request) {
		request.setAttribute("req", "리퀘스트데이터");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
	@RequestMapping("/model_map.do")
	public String map(Map map) {
		map.put("map", "맵데이타");
		/*
		 * request.setAttribute("map","멥데이타");
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("model_model.do")
	public String model(Model model) {
		model.addAttribute("model","모델데이타");
		/*
		 * request.setAttribute("model","모델데이타");
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("model_mapodel.do")
	public String modelmap(ModelMap modelMap) {
		modelMap.addAttribute("modelmap","모델맵데이타");
		/*
		 * request.setAttribute("model","모델데이타");
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
	@RequestMapping("/model_modelandview.do")
	public ModelAndView modelview() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("modelAndView", "모델앤드뷰데이타");
		/*
		request.setAttribute("modelAndView", "모델앤드뷰데이타");
		 */
		modelAndView.setViewName("forward:/WEB-INF/views/spring_model.jsp");
		return modelAndView;
	}
	@RequestMapping("model_all.do")
	public String model_all(HttpServletRequest request,
			                Model model,
			                Map map,
			                ModelMap modelMap) {
		request.setAttribute("req", "리퀘스트데이타");
		map.put("map", "맵데이타");
		model.addAttribute("model", "모델데이타");
		modelMap.addAttribute("modelmap", "모델맵데이타");
		
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
	
}