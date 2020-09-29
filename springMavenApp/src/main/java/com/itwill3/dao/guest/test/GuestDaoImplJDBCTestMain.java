package com.itwill3.dao.guest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill3.dao.guest.Guest;
import com.itwill3.dao.guest.GuestDao;

public class GuestDaoImplJDBCTestMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/guest/guest-dao-jdbc.xml");
		//applicationContext.getBean(GuestDao.class);
		GuestDao guestDao = (GuestDao)applicationContext.getBean("guestDao");
		System.out.println("------------insertGuest--------------");
		System.out.println("### "+guestDao.insertGuest(
				new Guest(1111, "guest_name", null, "guest_email", "guest_homepage", "guest_title", "guest_content")));
		System.out.println("------------selectByNo--------------");
		System.out.println("### "+guestDao.selectByNo(51));
		System.out.println("------------selectAll--------------");
		System.out.println("### "+guestDao.selectAll());
		
	}

}
