
package com.itwill.guest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;



public class GuestDaoImpl implements GuestDao{
	
	public GuestDaoImpl() throws Exception{
		
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_INSERT);
		pstmt.setString(1,guest.getGuest_name());
		pstmt.setString(2,guest.getGuest_email());
		pstmt.setString(3,guest.getGuest_homepage());
		pstmt.setString(4,guest.getGuest_title());
		pstmt.setString(5,guest.getGuest_content());
		int insertRowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return insertRowCount;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		Connection con = ConnectionFactory.getConnection(); //연결
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_NO); //SQL문 담기
		pstmt.setInt(1, no);  //pk 번호로 찾기
		Guest findGuest = null; //리턴 게스트 담을 객체 
		ResultSet rs = pstmt.executeQuery();  //실행 결과 담기?
		if(rs.next()) {
			findGuest = new Guest(rs.getInt("guest_no"),
								  rs.getString("guest_name"),
								  rs.getString("guest_date"),
								  rs.getString("guest_email"),
								  rs.getString("guest_homepage"),
								  rs.getString("guest_title"),
								  rs.getString("guest_content"));
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con); //다 닫아주기
		
		return findGuest; // 리턴
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		ResultSet rs= pstmt.executeQuery();
		while(rs.next()) {
			guestList.add(new Guest(rs.getInt("guest_no"),
									rs.getString("guest_name"),
									rs.getString("guest_date"),
									rs.getString("guest_email"),
									rs.getString("guest_homepage"),
									rs.getString("guest_title"),
									rs.getString("guest_content")
									));
		}
		return guestList;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_UPDATE);
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		pstmt.setInt(6, guest.getGuest_no());
		int updateRowCount = pstmt.executeUpdate();
		ConnectionFactory.releaseConnection(con);
		pstmt.close();
		return updateRowCount;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_DELETE);
		pstmt.setInt(1, no);
		int deleteRowCount = pstmt.executeUpdate();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		return deleteRowCount;
	}

}
