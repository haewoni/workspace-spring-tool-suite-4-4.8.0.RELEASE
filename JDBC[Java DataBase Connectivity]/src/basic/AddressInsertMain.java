package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class AddressInsertMain {

	public static void main(String[] args) throws Exception {
		/***************설정파일로부터 DB 접속 얻기****************/ 
		String driverClass= "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user = "javapython30";
		String password = "javapython30";
		
		String insertSql = 	"insert into address values(address_no_seq.nextval,'guard','김경호','123-4568','경기도 성남시')";
		/*
		 * 1.Driver Class Loading
		 */
		Class.forName(driverClass);
		/*
		 * 2. Connection 생성
		 */
		Connection con = DriverManager.getConnection(url,user,password);
		/*
		 * 3. Statement 생성
		 */
		Statement stmt = con.createStatement();
		/*
		 * 4. Statement를 사용해 SQL 전송(DML)
		 */
		/*
		 * <<java.sql.Statement>>
		 * public int executeUpdate(String sql) throws SQLException
			Executes the given SQL statement,
			which may be an INSERT, UPDATE, or DELETE statement 
			or an SQL statement that returns nothing, 
			such as an SQL DDL statement.
		 return:
		 	either (1) the row count for SQL Data Manipulation Language (DML) statements 
		 	or (2) 0 for SQL statements that return nothing	
		 */
	
		int rowCount = stmt.executeUpdate(insertSql);
		System.out.println(rowCount+"행 insert");
		
		stmt.close();
		con.close();
		
	}

}
