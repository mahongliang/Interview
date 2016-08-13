package com.interview.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisReadAll {
	public static void main(String[] args) throws IOException {
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		
		
//		List<Student> students = session.selectList("Student.getAll");
//		for (Student student : students) {
//			System.out.println(student.getId());
//			System.out.println(student.getName());
//			System.out.println(student.getBranch());
//			System.out.println(student.getPercentage());
//			System.out.println(student.getEmail());
//			System.out.println(student.getPhone());
//		}
//		System.out.println("Records Read Successfully");
		
		Student student = session.selectOne("Student.getById",2);
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getBranch());
		System.out.println(student.getPercentage());
		System.out.println(student.getEmail());
		System.out.println(student.getPhone());
		session.commit();
		session.close();

	}

}
