package com.mybatis3.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDaoDynamicSqlMain {

	public static void main(String[] args) throws Exception{
		StudentDaoDynamicSql studentDaoDynamicSql = new StudentDaoDynamicSql();
		System.out.println("---------findStudents---------");
		Student findStudent=new Student();
		System.out.println("### "+studentDaoDynamicSql.findStudents(findStudent));
		findStudent.setStudId(1);
		findStudent.setEmail("khm@gmail.com");
		findStudent.setName("신혜원");
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date dob = dateFormat.parse("2000-01-01");
		//findStudent.setDob(dob);
		System.out.println("### "+studentDaoDynamicSql.findStudents(findStudent));
		System.out.println("---------updateStudentById---------");
		Student updateStudent = new Student();
		updateStudent.setStudId(1);
		updateStudent.setName("반장님");
//		updateStudent.setEmail(System.currentTimeMillis()+"itwill@gmail.com");
//		updateStudent.setDob(new Date());
		System.out.println("###"+studentDaoDynamicSql.updateStudentById(updateStudent));
		System.out.println("--------findStudentsOrder----------");
		System.out.println("### "+studentDaoDynamicSql.findStudentsOrder("stud_id"));
			
	}
}
