package com.interview.springioc;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.jdom2.Document;
import org.jdom2.Element;

import org.jdom2.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory{

	
	private Map<String, Object> beans = new HashMap<>();
	
	public ClassPathXmlApplicationContext() throws Exception {
		SAXBuilder builder = new SAXBuilder();
		
		Document document = builder.build(this.getClass().getClassLoader().getResourceAsStream("resource/beans.xml"));
		Element root = document.getRootElement();
		List<Element> list = root.getChildren("bean");
		
		for (int i = 0; i < list.size(); i++) {
			Element element = (Element)list.get(i);
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");
			System.out.println(id+" : "+clazz);
			Object object = Class.forName(clazz).newInstance();//1：实例化bean对象
			beans.put(id, object);
			
			/** 
             *  <bean id="u" class="com.hzy.dao.impl.UserDAOImpl"/> 
     
                <bean id="userService" class="com.hzy.service.UserService"> 
                    <property name="userDAO" bean="u"/> 
                </bean> 
             */  
			
			
			//2：依赖注入，获得bena的property属性
			for (Element propertyElement : element.getChildren("property")) {
				String name = propertyElement.getAttributeValue("name");
				String injectBean = propertyElement.getAttributeValue("bean");	
				Object propertyObj = beans.get(injectBean);
				
				
				//3：拼接userService中的userDAO属性的setter方法
				
				//得到setUserDAO
				
				String methodName = "set"+name.substring(0, 1).toUpperCase()+name.substring(1);	
				System.out.println("method name = "+methodName);
				
				//通过反射机制，得到set方法
				Method method = object.getClass().getMethod(methodName, propertyObj.getClass().getInterfaces());
				//4：注入依赖对象
				method.invoke(object, propertyObj);
			}
			
		}
		
	}
	@Override
	public Object getBean(String name) {
		// TODO Auto-generated method stub
		return beans.get(name);
	}

}
