package com.itwill.guest.mapper;

import java.util.List;

import com.itwill.guest.Guest;

public interface GuestMapper {
	public List<Guest> selectAll();
	/*
	 * <select id="selectAll" resultType="com.itwill.guest.Guest">
		select * from guest
		</select>
	*/
	public Guest selectByNo(Integer guest_no);
	/*
		<select id="selectByNo" resultType="com.itwill.guest.Guest">
			select * from guest
			where
			guest_no=#{guest_no}
		</select>
	 */
}
