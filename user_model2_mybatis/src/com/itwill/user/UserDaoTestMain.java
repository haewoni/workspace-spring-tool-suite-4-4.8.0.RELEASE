package com.itwill.user;

public class UserDaoTestMain {
	public static void main(String[] args) {
		
	UserDaoMyBatis userDao = new UserDaoMyBatis();
	System.out.println("------findUserList------");
	System.out.println("###"+userDao.findUserList());;
	System.out.println("------findUser------");
	System.out.println("###"+userDao.findUser("guard2"));
//	System.out.println("------create------");
	User user = new User("hehehe","1111","황지희","hehe@gmail.com");
	System.out.println("###"+userDao.create(user));
	System.out.println("------update------");
	User user1 = new User("hahahah","0000","김민정","ha@gmail.com");
	user1.setName(new String());
	System.out.println("###"+userDao.update(user1));
 }
}