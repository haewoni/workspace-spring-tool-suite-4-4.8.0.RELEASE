package com.itwill.guest;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GuestDaoImplMyBatis implements GuestDao {
	private SqlSessionFactory sqlSessionFactory;
	public final static String NAMESPACE=
			"com.itwill.guest.mapper.GuestMapper.";
	
	public GuestDaoImplMyBatis() throws Exception {
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
		int insertRowCount = sqlSession.insert(NAMESPACE+"insertGuest",guest);
		sqlSession.commit(); ///create 은 commit 해주기
		sqlSession.close();
		return insertRowCount;
	}
	/*
	 * READ ONE
	 */
	@Override
	public Guest selectByNo(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Guest guest = sqlSession.selectOne(NAMESPACE+"selectByNo",no);
		sqlSession.close();
		return guest;
	}


	/*
	 * READ ALL
	 */
	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		List<Guest> guestList2 = sqlSession.selectList(NAMESPACE+"selectAll");
		guestList = (ArrayList<Guest>)guestList2;
		sqlSession.close();
		return guestList;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_UPDATE);
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		pstmt.setInt(6, guest.getGuest_no());
		int updateRowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return updateRowCount;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_DELETE);
		pstmt.setInt(1, no);
		int deleteRowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return deleteRowCount;
	}
}
