<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	/*
	
	


*/
	
	// 0. GET방식이면 guest_write_form.jsp redirection
	
	if(request.getMethod().equals("GET")){
		response.sendRedirect("guest_write_form.jsp");
		return;
	}
	
	// 0 . 요청객체 인코딩설정
	request.setCharacterEncoding("UTF-8");
	
	//1 . 파라메타받기- 5개받기
	String guest_name = request.getParameter("guest_name");
	String guest_email = request.getParameter("guest_email");
	String guest_homepage = request.getParameter("guest_homepage");
	String guest_title = request.getParameter("guest_title");
	String guest_content = request.getParameter("guest_content");
	
	try{
		Guest guest = 
			new Guest(guest_name,guest_email,guest_homepage,guest_title,guest_content);
		
		GuestService guestService = new GuestService();
		guestService.insertGuest(guest);
		/*
		2 . Service객체 메쏘드호출(업무처리)- GuestService.insertGuest()
		
	    3 . 요청클라이언트로 응답 
			- 성공:guest_main.jsp 로 redirection
			- 실패:guest_error.jsp로 redirection
		*/
		response.sendRedirect("guest_list.jsp");
	} catch (Exception e){
		e.printStackTrace();
		response.sendRedirect("guest_error.jsp");
	}
		
	

	
%>
