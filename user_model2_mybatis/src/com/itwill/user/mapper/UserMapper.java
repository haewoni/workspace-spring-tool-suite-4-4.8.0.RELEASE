package com.itwill.user.mapper;

import java.util.List;

import com.itwill.user.User;

public interface UserMapper {
	
	public List<User> findUserList();
	
	public User findUser(String userId);
	
	public int create(User user);
	
	public int update(User user);
	
	
	

}
