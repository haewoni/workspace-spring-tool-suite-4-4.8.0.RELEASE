package com.itwill3.dao.guest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("guestDaoMyBatis")
public class GuestDaoImplMyBatis implements GuestDao {
	@Autowired
	private SqlSession sqlSession;
	public static final String NAMESPACE=
			"com.itwill3.dao.guest.mapper.GuestMapper.";
	public GuestDaoImplMyBatis() {
	
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		int insertRowCount = sqlSession.insert(NAMESPACE+"insertGuest",guest);
		sqlSession.commit();
		return insertRowCount;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest findGuest = 
				sqlSession.selectOne(NAMESPACE+"selectByNo",no);
		return findGuest;
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		List<Guest> guestList1=sqlSession.selectList(NAMESPACE+"selectAll");
		ArrayList<Guest> guestList2=(ArrayList<Guest>)guestList1;
		return guestList2;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		
		int updateRowCount = sqlSession.update(NAMESPACE+"updateGuest",guest);
		sqlSession.commit();
		return updateRowCount;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		int deleteRowCount = sqlSession.delete(NAMESPACE+"deleteGuest",no);
		return deleteRowCount;
	}

}
