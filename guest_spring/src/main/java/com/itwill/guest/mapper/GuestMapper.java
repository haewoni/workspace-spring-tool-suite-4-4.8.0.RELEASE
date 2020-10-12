package com.itwill.guest.mapper;

import java.util.ArrayList;

import com.itwill.guest.Guest;

public interface GuestMapper {

	/*
	 * CREATE
	 */
	int insertGuest(Guest guest) throws Exception;

	/*
	 * READ ONE
	 */
	Guest selectByNo(int no) throws Exception;

	/*
	 * READ ALL
	 */
	ArrayList<Guest> selectAll() throws Exception;

	/*
	 * UPDATE
	 */
	int updateGuest(Guest guest) throws Exception;

	/*
	 * DELETE
	 */
	int deleteGuest(int no) throws Exception;

}