package com.interview.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetRecordByName { 

   public static void main(String args[]) throws IOException{
	   
      String req_name = "Moha";
      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
      SqlSession session = sqlSessionFactory.openSession();
      Student stud = new Student();
      stud.setName(req_name);
      
      //select contact all contacts		
      //List<Student> student = session.selectList("getRecByName",stud);
      
      stud.setId(1);
      List<Student> student = session.selectList("Student.getRecByName",stud);
          
      for(Student st : student ){    	  
    	   	  
         System.out.println("++++++++++++++details of the student named Mohammad are "+"+++++++++++++++++++" );
    	  
         System.out.println("Id :  "+st.getId());
         System.out.println("Name :  "+st.getName());
         System.out.println("Branch :  "+st.getBranch());
         System.out.println("Percentage :  "+st.getPercentage());         
         System.out.println("Email :  "+st.getEmail());        
         System.out.println("Phone :  "+st.getPhone());    	  
    	 
      }     
      
      System.out.println("Records Read Successfully ");          
      session.commit();   
      session.close();			
   }
}
