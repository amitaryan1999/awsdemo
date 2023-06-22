package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.User;
import com.rest.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userrepository;
	
	@Override
	public User saveUser(User uobj) 
	{
		Optional<User> optional = this.userrepository.findById(uobj.getUserId());
		User adduobj = null;
		
		if(optional.isPresent())
		{
			System.out.println("User Details already exists ...");
		}
		else
		{		
			adduobj = this.userrepository.save(uobj);
		}
		return adduobj;
	}

	@Override
	public User updateUser(User uobj, int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		
		return this.userrepository.findAll();
		
	}

	@Override
	public boolean delUser(int uid) {
		// TODO Auto-generated method stub
		return false;
	}
}