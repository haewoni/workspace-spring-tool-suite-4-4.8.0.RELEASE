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


public class UserDaoMyBatis {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.itwill.user.mapper.UserMapper.";
		
	public UserDaoMyBatis() {
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
//	public int create(User user) {
//		
//	}
//
//	/*
//	 * 기존의 사용자정보를 수정
//	 */
//	public int update(User user) {
//		
//	}
//
//	/*
//	 * 사용자아이디에해당하는 사용자를 삭제
//	 */
//	public int remove(String userId)  {
//		
//	}
//
//	/*
//	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서 User 도메인클래스에 저장하여 반환
//	 */
//	public User findUser(String userId)  {
//	
//	}

	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 List<User> 콜렉션 에 저장하여 반환
	 */
	public List<User> findUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userList =
				sqlSession.selectList(NAMESPACE+"findUserList");
		sqlSession.close();
		return userList;
	}
	public User findUser(String userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User findUser =
				sqlSession.selectOne(NAMESPACE+"findUser",userId);
		sqlSession.close();
		return findUser;
	}
	public int create(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertRowCount = sqlSession.insert(NAMESPACE+"create",user);
		sqlSession.close();
		return insertRowCount;
	}
	public int update(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int updateRowCount = sqlSession.insert(NAMESPACE+"update",user);
		sqlSession.close();
		return updateRowCount;
	}
	
	
	

//	/*
//	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
//	 */
//	public boolean existedUser(String userId) {
//		Connection con = null;
//		
//	}

}
