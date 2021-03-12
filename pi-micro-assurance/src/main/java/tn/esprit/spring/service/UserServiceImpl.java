package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInterface {
	
	
	@Autowired
	UserRepository userRep;

	@Override
	public List<User> retrieveAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User retrieveUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
