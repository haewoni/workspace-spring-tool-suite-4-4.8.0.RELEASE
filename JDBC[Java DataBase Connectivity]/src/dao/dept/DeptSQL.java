package dao.dept;

public class DeptSQL {
	/*
	    이름     널?       유형           
		------ -------- ------------ 
		DEPTNO NOT NULL NUMBER(2)    
		DNAME           VARCHAR2(14) 
		LOC             VARCHAR2(13) 
	 */
	public static final String INSERT = "insert into dept values(?,?,?)";
	public static final String SELECTBYNO = "select * from dept where deptno = ?";
	public static final String SELECTBYALL = "select * from dept";
	
}
