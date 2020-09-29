package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressSelectAllMain {

	public static void main(String[] args) throws Exception {
		/*************** DB 접속 정보****************/ 
		
		String driverClass= "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user = "javapython30";
		String password = "javapython30";
		
		String selectSql="select no,id,name,phone,address from address";
		
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
		/*
		 * <<ResultSet>>
		 * boolean next() throws SQLException
		 */
		//rs.getInt("no");    //데이타가 없음 before first 커서
		
		while(rs.next()) {
			/*
			 * DB NUMBER		 --> java int, double
			 * DB VARCHAR2, CHAR --> String
			 * DB DATE           --> Date			 
			 * XXX car = rs.getXXX(컬럼이름);
			 */
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
			
		}
		//rs.getInt("no");  
		rs.close();
		stmt.close();
		con.close();
				
	

	}

}
