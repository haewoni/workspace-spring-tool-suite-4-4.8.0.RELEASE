package com.itwill.guest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.guest.mapper.GuestMapper;

public class GuestDaoImplMyBatisMapperInterface implements GuestDao {
	private SqlSessionFactory sqlSessionFactory;
	
	
	public GuestDaoImplMyBatisMapperInterface() {
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
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		int insertRowCount =0;
		insertRowCount = guestMapper.insertGuest(guest);
		return insertRowCount;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		return sqlSessionFactory.openSession(true).getMapper(GuestMapper.class).selectByNo(no);
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		
		ArrayList<Guest> guestList1= new ArrayList<Guest>();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		ArrayList<Guest> guestList2=(ArrayList<Guest>)guestList1;
		return guestList2;
	}

	@Override
	public int updateGuest(Guest updateGuest) throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int updateRowCount=0;
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		guestMapper.updateGuest(updateGuest);
		return updateRowCount;
	}

	@Override
	public int deleteGuest(int guest_no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int deleteRowCount = sqlSession.getMapper(GuestMapper.class).deleteGuest(guest_no);
		return deleteRowCount;
	}

}
