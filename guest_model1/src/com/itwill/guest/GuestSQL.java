package com.itwill.guest;


public class GuestSQL {
	public static final String GUEST_INSERT="insert into GUEST values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
	public static final String GUEST_DELETE="delete from guest where guest_no =?";
	public static final String GUEST_UPDATE="update guest set "
			+ "				  guest_name=?,\r\n" + 
			"                 guest_email=?,\r\n" + 
			"                 guest_homepage=?,\r\n" + 
			"                 guest_title=?,\r\n" + 
			"                 guest_content=?     "
			+ "						 where guest_no = ?";
	public static final String GUEST_SELECT_NO="select * from guest where guest_no=?";
	public static final String GUEST_SELECT_ALL="select * from guest";
}
