package dao.address.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import basic.JDBCFlowMain;

public class AddressDao1 {
	/*
	Dao(Data Access Object)
	 - Address들의 데이터를 저장하고있는 Address 테이블에
	   CRUD(Create, Read, Update, Delete) 작업을 할수있는
	   단위메쏘드를 가지고있는 클래스
	 - AddressService객체의 요청(메쏘드호출)을 받아서 
	   Data Access(DB)에 관련된 단위기능(CRUD)을
	   수행하는 객체
	 */	
	public void create() throws Exception{
		
		String driverClass= "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user = "javapython30";
		String password = "javapython30";
		
		String insertSql = 	"insert into address values(address_no_seq.nextval,'guard','김경호','123-4568','경기도 성남시')";
	
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(rowCount+"행 insert");
		
		stmt.close();
		con.close();
		
	}
	
	public void delete() throws Exception{
		String driverClass= "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user = "javapython30";
		String password = "javapython30";
		
		String deleteSql = 	"delete address where no=1";
		
		Class.forName(driverClass);
		
		Connection con = DriverManager.getConnection(url,user,password);
		
		Statement stmt = con.createStatement();
		
	
		int rowCount = stmt.executeUpdate(deleteSql);
		System.out.println(rowCount+"행 delete");
		
		stmt.close();
		con.close();
		
	}
	public void update() throws Exception{
		String driverClass= "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user = "javapython30";
		String password = "javapython30";
		
		String updateSql = 	"update address set id='xxx',name='김경호',phone='888-8888',address='서울시 강남구'\r\n" + 
				"where no=1";
		
		Class.forName(driverClass);
		
		Connection con = DriverManager.getConnection(url,user,password);
		
		Statement stmt = con.createStatement();
		
	
		int rowCount = stmt.executeUpdate(updateSql);
		System.out.println(rowCount+"행 update");
		
		stmt.close();
		con.close();
	}
	public void selectByNo() throws Exception{
		String driverClass= "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user = "javapython30";
		String password = "javapython30";
		
		String selectSql="select no,id,name,phone,address from address where no=3";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt=con.createStatement();
		/*
		 * <<Statement>>
		 * ResultSet executeQuery(String sql) throws SQLException
			Executes the given SQL statement, which returns a single ResultSet object.
			Note:This method cannot be called on a PreparedStatement or CallableStatement.
			
			Parameters:
				sql - an SQL statement to be sent to the database, 
				typically a static SQL SELECT statement 
			Returns:
				a ResultSet object that contains the data produced by the given query; never null
		 */

		ResultSet rs=stmt.executeQuery(selectSql);
		
		if(rs.next()) {
			
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
			
		}
		rs.close();
		stmt.close();
		con.close();
	}
	public void selectAll() throws Exception{
		String driverClass= "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user = "javapython30";
		String password = "javapython30";
		
		String selectSql="select no,id,name,phone,address from address";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(selectSql);
		
		while(rs.next()) {
		
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
			
		}
		  
		rs.close();
		stmt.close();
		con.close();
				
	}
	
}