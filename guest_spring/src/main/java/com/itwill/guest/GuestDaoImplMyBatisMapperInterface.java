package com.itwill.guest;

import java.io.InputStream;

import java.util.ArrayList;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.itwill.guest.mapper.GuestMapper;
@Component
public class GuestDaoImplMyBatisMapperInterface implements GuestDao,GuestMapper {
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private GuestDao guestDao;

	public GuestDaoImplMyBatisMapperInterface(GuestDao guestDao) {
		this.guestDao = guestDao;
	}


	public GuestDaoImplMyBatisMapperInterface() throws Exception {
		/*
		 * 모든 마이바티스 애플리케이션은 SqlSessionFactory 인스턴스를 사용한다. 
		 * SqlSessionFactory인스턴스는 SqlSessionFactoryBuilder를 사용하여 만들수 있다. 
		 * SqlSessionFactoryBuilder는 XML설정파일에서 
		 * SqlSessionFactory인스턴스를 빌드할 수 있다. 
		 * XML파일에서 SqlSessionFactory인스턴스를 빌드하는 것은 매우 간단한다. 
		 * 설정을 위해 클래스패스 자원을 사용하는 것을 추천하나 
		 * 파일 경로나 file:// URL로부터 만들어진 InputStream인스턴스를 사용할 수도 있다. 
		 * 마이바티스는 클래스패스와 다른 위치에서 자원을 로드하는 것으로 좀더 쉽게 해주는 
		 * Resources 라는 유틸성 클래스를 가지고 있다.
		 */
		InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
		this.sqlSessionFactory= 
				new SqlSessionFactoryBuilder().build(in);
	}
	 

	/*
	 * CREATE
	 */
	@Override
	public int insertGuest(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		int insertRowCount = guestMapper.insertGuest(guest);
		return insertRowCount;
	}
	/*
	 * READ ONE
	 */
	@Override
	public Guest selectByNo(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		Guest guest= guestMapper.selectByNo(no);
		return guest;
	}


	/*
	 * READ ALL
	 */
	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper = sqlSession.getMapper(GuestMapper.class);
		guestList = guestMapper.selectAll();
		return guestList;
	}
	/*
	 * UPDATE
	 */
	@Override
	public int updateGuest(Guest guest) throws Exception {
		return sqlSessionFactory.openSession(true).getMapper(GuestMapper.class).updateGuest(guest);
		
	}
	/*
	 * DELETE
	 */
	@Override
	public int deleteGuest(int no) throws Exception {
		return sqlSessionFactory.openSession(true).getMapper(GuestMapper.class).deleteGuest(no);
	}
}
