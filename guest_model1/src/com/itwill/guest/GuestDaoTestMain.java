package com.itwill.guest;


public class GuestDaoTestMain {

	public static void main(String[] args) throws Exception {
		GuestDao guestDao = new GuestDaoImpl();   //dao 객체 생성

//		Guest guest = new Guest("신혜원","suzyhw96@gmail.com","www.haewoni.com","안녕안녕","오늘은 8월 25일");
//		System.out.println("1.insert:"+guestDao.insertGuest(guest));
		System.out.println("2.selectByNo:"+guestDao.selectByNo(5));
		System.out.println("3.selectAll:"+guestDao.selectAll()); 
		Guest guest1 = new Guest("신혜원","haewoni@naver.com","http://naver.com ","안녕안녕","오늘은 26일",5);
		System.out.println("4.update:"+guestDao.updateGuest(guest1)); 
		System.out.println("5.delete:"+guestDao.deleteGuest(3));

	}

}
