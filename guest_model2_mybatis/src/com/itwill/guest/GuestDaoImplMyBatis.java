package com.itwill.guest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GuestDaoImplMyBatis implements GuestDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE="com.itwill.guest.mapper.GuestMapper.";
	public GuestDaoImplMyBatis() {
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			sqlSessionFactory=ssfb.build(mybatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int insertRowCount = sqlSession.insert(NAMESPACE+"insertGuest",guest);
		sqlSession.close();
		return insertRowCount;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Guest findGuest = 
				sqlSession.selectOne(NAMESPACE+"selectByNo",no);
		sqlSession.commit();
		sqlSession.close();
		return findGuest;
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<Guest> guestList1=sqlSession.selectList(NAMESPACE+"selectAll");
		ArrayList<Guest> guestList2=(ArrayList<Guest>)guestList1;
		return guestList2;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int updateRowCount = sqlSession.update(NAMESPACE+"updateGuest",guest);
		sqlSession.close();
		return updateRowCount;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int deleteRowCount = sqlSession.delete(NAMESPACE+"deleteGuest",no);
		return 0;
	}

}
