package com.itwill3.dao.guest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.UserDao;

public class GuestDaoImplJDBCAnnotationTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/guest/guest-dao-jdbc-annotation.xml");
		/*
		GuestDao guestDao = (GuestDao)applicationContext.getBean("guestDao");
		System.out.println("--------findUserList------------");
		guestDao.insertGuest(new Guest(1111,"",null,"guest_email","guest_homepage","guest_title","guest_content"));
		System.out.println(guestDao.selectAll());
*/
	}

}
