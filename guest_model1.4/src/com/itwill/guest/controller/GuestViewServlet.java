package com.itwill.guest.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestMainServlet
 */
@WebServlet("/guest_view.do")
public class GuestViewServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath="";
		
		/**************************************************/
		/*
		요청URL-->
		  http://192.16.15.31/guest_model1/guest_view.jsp?guest_no=2
			1 . 파라메타받기
			2 . Service객체 메쏘드호출(업무처리)
			3 . 요청클라이언트로 응답 
		*/
		String guest_noStr = request.getParameter("guest_no");
		if(guest_noStr==null||guest_noStr.equals("")){
			forwardPath="redirect:guest_list.do";
			
		}else {
			try {
				GuestService guestService=new GuestService();
				Guest guest=
						guestService.selectByNo(Integer.parseInt(guest_noStr));
				forwardPath="forward:guest_view.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:guest_error.jsp";
			}
		}
		
		
		
		/***************************************************/
		
		String [] pathArray = forwardPath.split(":");
		String forwardOrRedirect=pathArray[0];
		String path=pathArray[1];
		if(forwardOrRedirect.equals("redirect")) {
			response.sendRedirect(path);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}

}
