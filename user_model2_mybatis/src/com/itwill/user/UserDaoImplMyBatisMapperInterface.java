package com.itwill.user;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.user.mapper.UserMapper;


public class UserDaoImplMyBatisMapperInterface {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.itwill.user.mapper.UserMapper.";
		
	public UserDaoImplMyBatisMapperInterface() {
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			sqlSessionFactory=ssfb.build(mybatisConfigInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<User> findUserList() {
		return sqlSessionFactory.openSession(true).getMapper(UserMapper.class).findUserList();
	}
	public User findUser(String userId) {
		return sqlSessionFactory.openSession(true).getMapper(UserMapper.class).findUser(userId);
	}
	public int create(User user) {
		return sqlSessionFactory.openSession(true).getMapper(UserMapper.class).create(user);
	}
	public int update(User user) {
		return sqlSessionFactory.openSession(true).getMapper(UserMapper.class).update(user);
	}
	
	
	

//	/*
//	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
//	 */
//	public boolean existedUser(String userId) {
//		Connection con = null;
//		
//	}

}
