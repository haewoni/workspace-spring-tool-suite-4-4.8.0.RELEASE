package com.itwill.guest;

import java.util.ArrayList;

public class GuestService {
	private GuestDao guestDao;
	public GuestService() throws Exception {
		guestDao=new GuestDaoImpl();
	}
	/*
	 * Create
	 */
	public int insertGuest(Guest guest) throws Exception{
		int insertGuest = guestDao.insertGuest(guest);
		return insertGuest;
	} 
	/*
	 * Read
	 */
	public Guest selectByNo(int no) throws Exception{
		Guest selectByNo = guestDao.selectByNo(no);
		return selectByNo;
	}
	public ArrayList<Guest> selectAll() throws Exception{
		return guestDao.selectAll();
	}
	/*
	 * Update
	 */
	public int updateGuest(Guest guest) throws Exception{
		int updateGuest = guestDao.updateGuest(guest);
		return updateGuest;
	}
	/*
	 * Delete
	 */
	public int deleteGuest(int no) throws Exception{
		int deleteGuest = guestDao.deleteGuest(no);
		return deleteGuest;
	}
}
