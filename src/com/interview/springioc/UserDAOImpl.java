package com.interview.springioc;

public class UserDAOImpl implements UserDAO{

	@Override
	public void save(User u) {
		
		System.out.println("a user saved!");
	}

}
