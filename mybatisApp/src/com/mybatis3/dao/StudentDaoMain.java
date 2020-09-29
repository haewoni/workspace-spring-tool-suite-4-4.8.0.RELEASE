package com.mybatis3.dao;

import java.util.Date;
import java.util.HashMap;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		
		System.out.println("-------findStudentById-------");
		System.out.println("###"+studentDao.findStudentById(3));
		System.out.println("---------findAllStudents---------");
		System.out.println("###"+studentDao.findAllStudents());
		System.out.println("-------findStudentByIdResultMap-------");
		System.out.println("###"+studentDao.findStudentByIdResultMap(3));
		System.out.println("---------insertStudent(Dto)--------------");
		//Student student1=new Student(8000, "김팔천", "eight@gmail.com", new Date());
		//System.out.println("###"+studentDao.insertStudent(student1));
		System.out.println("---------insertStudentBySequence1---------");
		Student student2=
				new Student(null, "김시퀀스1", "seq1@gmail.com", new Date());
		System.out.println("###"+studentDao.insertStudentBySequence1(student2));
		System.out.println("insert PK -->"+student2.getStudId());
		System.out.println("---------insertStudentBySequence2---------");
		Student student3=
				new Student(null, "김시퀀스2", "seq2@gmail.com", new Date());
		System.out.println("###"+studentDao.insertStudentBySequence2(student3));
		System.out.println("insert PK -->"+student3.getStudId());
		System.out.println("---------updateStudent-------------------");
		Student updateStudent = studentDao.findStudentById(1);
		//updateStudent.setName("변경2");
		//updateStudent.setEmail("change2@gmail.com");
		updateStudent.setDob(new Date());
		System.out.println("###"+studentDao.updateStudent(updateStudent));
		System.out.println("---------deleteStudentById------------------");
		System.out.println("###"+studentDao.deleteStudentById(10));
		System.out.println("###"+studentDao.deleteStudentByName("김팔천"));
		System.out.println("###"+studentDao.deleteStudentByNameLike("김시퀀스"));
		System.out.println("---------findStudentByIdWithAddress----------");
		System.out.println("###"+studentDao.findStudentByIdWithAddress(3));
		System.out.println("---------findStudentByIdWithCourses----------");
		System.out.println("###"+studentDao.findStudentByIdWithCourses(2));
		System.out.println("---------findStudentNameList----------");
		System.out.println("### "+studentDao.findStudentNameList());
		System.out.println("---------findStudentNameById----------");
		System.out.println("### "+studentDao.findStudentNameById(1));
		System.out.println("-------findStudentByIdMap-------");
		System.out.println("### "+studentDao.findStudentByIdMap(1));
		System.out.println("------------findAllStudentsMapList-------------");
		System.out.println("### "+studentDao.findAllStudentsMapList());
		System.out.println("---------updateStudentParamMap(parameter Map)----");
		HashMap studentMap=new HashMap();
		studentMap.put("studId",1);
		studentMap.put("name","유노유노");
		studentMap.put("email","you@no.co.kr");
		studentMap.put("dob",new Date());
		System.out.println("### "+studentDao.updateStudentParamMap(studentMap));
		System.out.println("---------findStudentByIdRangeParamMap(parameter Map)----");
		HashMap rangeMap=new HashMap();
		rangeMap.put("startNo", 1);
		rangeMap.put("endNo", 3);
		System.out.println("### "+studentDao.findStudentByIdRangeParamMap(rangeMap));
		System.out.println("---------findStudentsThreeParamMap(parameter Map)----");
		Student s1 = new Student(1);
		Student s3 = new Student(3);
		Student s5 = new Student(5);
		HashMap threeStudentMap = new HashMap();
		threeStudentMap.put("first", s1);
		threeStudentMap.put("second", s3);
		threeStudentMap.put("third", s5);
		System.out.println("###"+studentDao.findStudentsThreeParamMap(threeStudentMap));
		
		
		/*
		System.out.println("---------findAllStudentsResultMap---------");
		System.out.println("---------findStudentByIdNestedfindAddressById-----------");
		System.out.println("---------updateStudentDynamicSql---------");
		System.out.println("---------findStudentCount----------------");
		*/
	}
}
