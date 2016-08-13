package com.interview.springioc;

public class UserServiceTest {
	public static void main(String[] args) throws Exception {
		BeanFactory factory = new ClassPathXmlApplicationContext();
		UserService service = (UserService)factory.getBean("userService");
		User user = new User();
		service.add(user);
	}
}
