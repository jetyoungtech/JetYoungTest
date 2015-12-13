package com.jet.spring.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jet.spring.annotation.TestObject;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired(required=false)
	private TestObject testObject;

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepository save.....");
		System.out.println(testObject);

	}

}
