<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*
	1.파라메타바끼
	2.GuestService.updateGuest()메쏘드호출
	3.성공 -->guest_view.jsp redirection
	  실패-->guest_error.jsp redirection
	*/
	if(request.getMethod().equals("GET")) {
		response.sendRedirect("guest_main.jsp");
		return;
	}
	  
	try{
		request.setCharacterEncoding("UTF-8");
		String guest_no = request.getParameter("guest_no");
		String guest_name = request.getParameter("guest_name");
		String guest_title = request.getParameter("guest_title");
		String guest_homepage = request.getParameter("guest_homepage");
		String guest_content = request.getParameter("guest_content");
		
		GuestService guestService = new GuestService();
		Guest guest = 
				new Guest(guest_name,guest_homepage,guest_title,guest_content,Integer.parseInt(guest_no));
		
		guestService.updateGuest(guest);
		
		response.sendRedirect("guest_view.jsp?guest_no="+guest_no);
		
	}catch (Exception e) {
		e.printStackTrace();
		response.sendRedirect("guest_error.jsp");
	}
	
	  
%>

