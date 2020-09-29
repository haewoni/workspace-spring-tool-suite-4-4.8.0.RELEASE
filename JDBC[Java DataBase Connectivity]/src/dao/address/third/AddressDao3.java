package dao.address.third;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import dao.address.Address;

public class AddressDao3 {
	/************** DB접속정보 **************/
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
	String user = "javapython30";
	String password = "javapython30";
	
	/*
	    이름      널?       유형            
		------- -------- ------------- 
		NO      NOT NULL NUMBER(4)     
		ID               VARCHAR2(20)  
		NAME             VARCHAR2(50)  
		PHONE            VARCHAR2(50)  
		ADDRESS          VARCHAR2(100) 
	 */
	
	public int create(Address insertAddress) throws Exception {
		String insertSql = "insert into address values(address_no_seq.nextval,?,?,?,?)";   //sql
		Class.forName(driverClass);  //드라이버 로딩
		Connection con = DriverManager.getConnection(url,user,password);  //접속,연결(길)
		PreparedStatement pstmt = con.prepareStatement(insertSql);  //트럭
		pstmt.setString(1,insertAddress.getId());
		pstmt.setString(2,insertAddress.getName());
		pstmt.setString(3,insertAddress.getPhone());
		pstmt.setString(4,insertAddress.getAddress());
		int insertRowCount = pstmt.executeUpdate();  //리턴값
		con.close();   //접속 닫기
		pstmt.close();  
		return insertRowCount; //실행된 횟수 리턴
	}
	
	
	
	public int delete(int no) throws Exception {
		String deleteSql = "delete address where no=?"; 
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = con.prepareStatement(deleteSql);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	public int update(Address updateAddress)  throws Exception{
		String updateSql = "update address set id=?,name=?,phone=?,address=? where no=?";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		pstmt.setString(1, updateAddress.getId());
		pstmt.setString(2, updateAddress.getName());
		pstmt.setString(3, updateAddress.getPhone());
		pstmt.setString(4, updateAddress.getAddress());
		pstmt.setInt(5, updateAddress.getNo());
		int updateRowCount = pstmt.executeUpdate();
		
		return updateRowCount;
	}
	
	public Address selectByNo(int fno) throws Exception {
		 String selectSql = "select*from address where no=?";
		 Class.forName(driverClass);
		 Connection con = DriverManager.getConnection(url,user,password);
		 PreparedStatement pstmt = con.prepareStatement(selectSql);
		 pstmt.setInt(1, fno);
		 ResultSet rs = pstmt.executeQuery();
			
		 Address findAddress = null;
		 while(rs.next()) {
			 int no = rs.getInt("no");
			 String id = rs.getString("id");
			 String name = rs.getString("name");
			 String phone = rs.getString("phone");
			 String address = rs.getNString("address");
			 
			 findAddress = new Address(no, id, name, phone, address);
		 }
		 rs.close();
		 pstmt.close();
		 con.close();
	
		
		return findAddress;
	}
	public ArrayList<Address> selectAll() throws Exception {
		 String selectAllSql = "select*from address";
		 Class.forName(driverClass);
		 Connection con = DriverManager.getConnection(url,user,password);
		 PreparedStatement pstmt = con.prepareStatement(selectAllSql);
		 ResultSet rs = pstmt.executeQuery();
			
		 ArrayList<Address> findAddressList = new ArrayList<Address>();
		 while(rs.next()) {
			 Address temp = new Address();
			 temp.setNo(rs.getInt("no"));
			 temp.setId(rs.getString("id"));
			 temp.setName(rs.getString("name"));
			 temp.setPhone(rs.getString("phone"));
			 temp.setAddress(rs.getString("address"));
			 findAddressList.add(temp);
		 }
		 rs.close();
		 pstmt.close();
		 con.close();
	
		 return findAddressList;
		
	
	}
}
