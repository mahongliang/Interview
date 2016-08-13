package com.interview.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class MybatisUpdate {
		
	public static void main(String[] args) throws IOException {
		 Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
	      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	      SqlSession session = sqlSessionFactory.openSession();
	      
//	      Student student = session.selectOne("Student.getById",1);
//	      System.out.println("Current details of the student are" );
//	      System.out.println(student.toString());
//	      
//	      student.setEmail("mohamed123@yahoo.com");
//	      student.setPhone(91100000);
//	      
//	      session.update("Student.update",student);
//	      System.out.println("Record updated successfully");   
//	      session.commit();   
////	      session.close();	  
//	      
//	    //verifying the record 
//	      Student std = (Student) session.selectOne("Student.getById", 1);
//	      System.out.println("Details of the student after update operation" );
//	      System.out.println(std.toString());   
//	      session.commit();   
//	      session.close();
	      
	      //select a particular student  by  id	
	      Student student = (Student) session.selectOne("Student.callById", 3);
	      
	      //Print the student details
	      System.out.println("Details of the student are:: ");
	      System.out.println("Id :"+student.getId());
	      System.out.println("Name :"+student.getName());
	      System.out.println("Branch :"+student.getBranch());
	      System.out.println("Percentage :"+student.getPercentage());      
	      System.out.println("Email :"+student.getEmail());      
	      System.out.println("Phone :"+student.getPhone());
	      session.commit();
	      session.close();
	      
	}

}
