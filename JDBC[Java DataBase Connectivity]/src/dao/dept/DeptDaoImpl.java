package dao.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.account.ConnectionFactory;

public class DeptDaoImpl implements DeptDao{
	
	/*
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@182.237.126.19:1521:XE";
	String user = "javapython30";
	String password = "javapython30";
	*/
	
	@Override
	public int insert(Dept department) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeptSQL.INSERT);
		pstmt.setInt(1, department.getDeptno());
		pstmt.setString(2, department.getDname());
		pstmt.setString(3, department.getLoc());
		int insertRowCount = pstmt.executeUpdate();
		ConnectionFactory.releaseConnection(con);
		pstmt.close();
		
		return insertRowCount;
	}

	@Override
	public Dept selectByNo(int deptno) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeptSQL.SELECTBYNO);
		pstmt.setInt(1, deptno);
		ResultSet rs = pstmt.executeQuery();
		
		Dept findDept = null;
		while(rs.next()) {
			int deptNo = rs.getInt("deptno");
			String dName = rs.getString("dname");
			String loc = rs.getString("loc");
			
			findDept = new Dept(deptno,dName,loc);
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		
		return findDept;
	}

	@Override
	public List<Dept> selectByAll() throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DeptSQL.SELECTBYALL);
		ResultSet rs = pstmt.executeQuery();
		
		List<Dept> findDeptAll = new ArrayList<Dept>();
		while(rs.next()) {
			Dept temp = new Dept();
			temp.setDeptno(rs.getInt("deptno"));
			temp.setDname(rs.getString("Dname"));
			temp.setLoc(rs.getString("Loc"));
			findDeptAll.add(temp);
		}
		rs.close();
		pstmt.close();
		ConnectionFactory.releaseConnection(con);
		
		return findDeptAll;
		
		
	}

}
