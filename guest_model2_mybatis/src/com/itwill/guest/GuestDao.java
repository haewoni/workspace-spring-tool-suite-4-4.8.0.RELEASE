package com.itwill.guest;


import java.util.ArrayList;
import java.util.List;

public interface GuestDao {
	
	/*
	 * Create
	 */
	public int insertGuest(Guest guest) throws Exception;
	/*
	 * Read
	 */
	public Guest selectByNo(int no) throws Exception;
	public List<Guest> selectAll() throws Exception;
	/*
	 * Update
	 */
	public int updateGuest(Guest updateGuest) throws Exception;
	/*
	 * Delete
	 */
	public int deleteGuest(int no) throws Exception;
}
