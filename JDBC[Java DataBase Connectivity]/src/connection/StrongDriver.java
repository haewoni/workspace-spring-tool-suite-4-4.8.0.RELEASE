package connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class StrongDriver implements Driver {     //모든 드라이버가 Driver 를 구현하고 있음
	
	private StrongDriver() {
		System.out.println("StrongDriver 기본생성자");
	}
		/*
		 * 정적메소드 : 클래스 로딩되면 생성되는 메소드 블록/ 호출할때 실행
		 */
	static {
		/*
		 * 정적블록 : 클래스 로딩되면 최초로 실행되는 블록/ 올라오면 바로 실행
		 */
		try {
			System.out.println("1.StongDriver 객체 생성");
			Driver driver = new StrongDriver();
			System.out.println("1.DriverManager 등록"); 
			DriverManager.deregisterDriver(driver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}
