package com.itwill.account;

public class AccountSQL {
	public static final String INSERT=
	"insert into account values(?,?,?,?)";
	public static final String UPDATE=
	"update account set owner=?,balance=?,iyul=? where no=?";
	public static final String DELETE=
	"delete account where no=?";
	public static final String SELECTBYNO=
	"select * from account where no=?";
	public static final String SELECTBYOWNER=
	"select * from account where owner=?";
	public static final String SELECTALL=
	"select * from account";
	
	
}
