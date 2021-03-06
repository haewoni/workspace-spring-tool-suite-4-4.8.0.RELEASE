package statement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;

import basic.JDBCFlowMain;

public class PreparedStatementMain {

	public static void main(String[] args) throws Exception {
		Properties dbProperties = new Properties();
		dbProperties.load(JDBCFlowMain.class.getResourceAsStream("db.properties"));
	
		String driverClass= dbProperties.getProperty("driverClass");
		String url = dbProperties.getProperty("url");
		String user = dbProperties.getProperty("user");
		String password = dbProperties.getProperty("password");
		
		int startSal = 1000;
		int endSal = 3000;
		String job = "SALESMAN";
		
		String selectSql1 = 
				"select * from emp where sal>= "+startSal+" and sal<="+endSal+" and job='"+job+"'";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println("---------------SELECT(Statement)-----------------");
		Statement stmt = con.createStatement();
		ResultSet rs= stmt.executeQuery(selectSql1);
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename = rs.getNString("ename");
			String jobs = rs.getNString("job");
			double sal = rs.getDouble("sal");
			System.out.println(empno+"\t"+ename+"\t"+jobs+"\t"+sal);
		} 
		rs.close();
		stmt.close();
		System.out.println("---------------SELECT(PreparedStatement)-----------------");
		String selectSql2 = "select * from emp where sal >= ? and sal <= ? and job = ?";		
		PreparedStatement pstmt = con.prepareStatement(selectSql2);
		pstmt.setInt(1, startSal);
		pstmt.setInt(2, endSal);
		pstmt.setString(3, job);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename = rs.getNString("ename");
			String jobs = rs.getNString("job");
			double sal = rs.getDouble("sal");
			System.out.println(empno+"\t"+ename+"\t"+jobs+"\t"+sal);
		}
		
		System.out.println("--------PreparedStatement반복-----");
		startSal=100;
		endSal=5000;
		job="SALESMAN";
		
		pstmt.setInt(1, startSal);
		pstmt.setInt(2, endSal);
		pstmt.setString(3, job);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename=rs.getString("ename");
			String jobs=rs.getString("job");
			double sal=rs.getDouble("sal");
			System.out.println(empno+"\t"+ename+"\t"+jobs+"\t"+sal);
			
		}
		rs.close();
		pstmt.close();
		/*
		 * 
		 */
		
		System.out.println("---------------INSERT(PreparedStatement)-----------------");
		String insertSql1 = "insert into emp values(?,?,?,?,?,?,?,?)";
		/*
		pstmt = con.prepareStatement(insertSql1);
		pstmt.setInt(1, 1000);
		pstmt.setString(2, "ALICE");
		pstmt.setString(3, "CLERK");
		pstmt.setInt(4, 7369);
		pstmt.setDate(5, new Date(System.currentTimeMillis()));
		pstmt.setDouble(6, 561.93);
		pstmt.setDouble(7, 30.67);
		pstmt.setInt(8, 30);
		int insertRowCount = pstmt.executeUpdate();
		System.out.println(insertRowCount+"행 insert...");
		*/
		
		String insertSql2 = "insert into emp values(?,?,?,?,sysdate,?,?,?)";
		/*
		pstmt = con.prepareStatement(insertSql2);
		pstmt.setInt(1, 2000);
		pstmt.setString(2, "TOM");
		pstmt.setString(3, "MANAGER");
		pstmt.setInt(4, 7369);
		pstmt.setDouble(5, 561.93);
		pstmt.setDouble(6, 30.67);
		pstmt.setInt(7, 30);
		int insertRowCount = pstmt.executeUpdate();
		System.out.println(insertRowCount+"행 insert...");
		*/
		String insertSql3 = "insert into emp values(?,?,?,?,to_date(?,?),?,?,?)";
		/*
		pstmt = con.prepareStatement(insertSql3);
		pstmt.setInt(1, 3000);
		pstmt.setString(2, "MARK");
		pstmt.setString(3, "SALESMAN");
		pstmt.setInt(4, 7369);
		pstmt.setString(5,"2019/01/12");
		pstmt.setString(6,"YYYY/MM/DD");
		pstmt.setDouble(7, 561.93);
		pstmt.setDouble(8, 30.67);
		pstmt.setInt(9, 30);
		int insertRowCount = pstmt.executeUpdate();
		System.out.println(insertRowCount+"행 insert...");
		*/
		String insertSql4 = "insert into emp values(?,?,?,?,to_date(?,?),?,?,?)";
		pstmt = con.prepareStatement(insertSql4);
		
		pstmt.setInt(1, 8000);
		pstmt.setString(2, "MARK");
		pstmt.setString(3, "SALESMAN");
		pstmt.setInt(4, 7369);
		/*********Date 객체 생성*********/
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		Date date = new Date(sdf.parse("2018-05-01").getTime());
		
		pstmt.setDate(5, date);
		pstmt.setString(6,"YYYY/MM/DD");
		pstmt.setDouble(7, 561.93);
		pstmt.setDouble(8, 30.67);
		pstmt.setInt(9, 30);
		int insertRowCount = pstmt.executeUpdate();
		System.out.println(insertRowCount+"행 insert...");
		
		pstmt.setInt(1, 8800);		
		insertRowCount = pstmt.executeUpdate();
		System.out.println(insertRowCount+" 행 insert...");
		
		pstmt.clearParameters();
		
		
		
		
		
		
	
		
		

	}

}
