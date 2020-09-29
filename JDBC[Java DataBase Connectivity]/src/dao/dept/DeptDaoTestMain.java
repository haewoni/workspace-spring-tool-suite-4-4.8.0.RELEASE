package dao.dept;

import java.util.List;

public class DeptDaoTestMain {

	public static void main(String[] args) throws Exception {
		DeptDao deptDao=new DeptDaoImpl();
		
	
		System.out.println("------------1.Insert----------------");
		int insertRowCount = deptDao.insert(new Dept(70,"BUYING","NY"));
		System.out.println(insertRowCount);
		
		
		System.out.println("------------2.selectByNo----------------");
		Dept findDept1 = deptDao.selectByNo(50);
		System.out.println(findDept1);
		
		System.out.println("------------3.selectAll--------------------");
		List<Dept> findDept2 = deptDao.selectByAll();
		System.out.println(findDept2);
		
		
		//deptDao.selectByNo(deptno);
		//deptDao.selectByAll();
	}

}
