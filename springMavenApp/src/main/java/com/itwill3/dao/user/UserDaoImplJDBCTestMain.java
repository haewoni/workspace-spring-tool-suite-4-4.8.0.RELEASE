package com.itwill3.dao.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill3.dao.guest.GuestDao;

public class UserDaoImplJDBCTestMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/user/user-dao-jdbc.xml");
		
	
	
	}

}
