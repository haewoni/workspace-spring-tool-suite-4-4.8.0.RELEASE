<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${pageContext.request.locale.language}" scope="session"/>
<fmt:setBundle basename="messages/guest"/>
<p>
	<strong><fmt:message key="menu.title"/></strong>
</p>
<ul>
	<li><a href="guest_list.do">방명록리스트</a></li>
	<li><a href="guest_write_form.do">방명록쓰기</a></li>

</ul>