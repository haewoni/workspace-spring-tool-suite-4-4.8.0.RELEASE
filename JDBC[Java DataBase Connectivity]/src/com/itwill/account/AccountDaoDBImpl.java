package com.itwill.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountDaoDBImpl implements AccountDao{

	@Override
	public boolean create(Account account) throws Exception {
		boolean insertOk=false;
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pstmt=con.prepareStatement(AccountSQL.INSERT);
			pstmt.setInt(1 ,account.getNo());
			pstmt.setString(2, account.getOwner());
			pstmt.setInt(3 ,account.getBalance());
			pstmt.setDouble(4 ,account.getIyul());
			int insertCount=pstmt.executeUpdate();
			insertOk=true;
		}catch (Exception e) {
			insertOk=false;
			e.printStackTrace();
		}
		return insertOk;
	}

	@Override
	public Account readOne(int no) throws Exception {
		Account account=null;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AccountSQL.SELECTBYNO);
		pstmt.setInt(1, no);
		ResultSet rs=pstmt.executeQuery();
		if (rs.next()) {
			account=new Account(
					rs.getInt("no"),
					rs.getString("owner"),
					rs.getInt("balance"),
					rs.getDouble("iyul"));
		}
		return account;
	}

	@Override
	public ArrayList<Account> readAll() throws Exception {
		ArrayList<Account> accountList=new ArrayList<Account>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AccountSQL.SELECTALL);
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()) {
			accountList.add(new Account(
					rs.getInt("no"),
					rs.getString("owner"),
					rs.getInt("balance"),
					rs.getDouble("iyul")));
		}
		return accountList;
	}

	@Override
	public ArrayList<Account> readByOwner(String ownerStr) throws Exception {
		ArrayList<Account> accountList=new ArrayList<Account>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(AccountSQL.SELECTBYOWNER);
		pstmt.setString(1, ownerStr);
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()) {
			accountList.add(new Account(
					rs.getInt("no"),
					rs.getString("owner"),
					rs.getInt("balance"),
					rs.getDouble("iyul")));
		}
		return accountList;
	}

	@Override
	public void update(Account updateAccount) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int no, String owner, int balalnce, double iyul) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int no) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
