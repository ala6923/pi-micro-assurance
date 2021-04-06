package tn.esprit.spring.service;

import java.util.ArrayList;
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
		List<User> list = new ArrayList<>();
        Iterable<User> items = userRep.findAll();
        items.forEach(list::add);
        return list; 
	}

	@Override
	public User addUser(User u) {
		
		return userRep.save(u);
	}

	@Override
	public boolean deleteUser(int id) {
		if (userRep.existsById(id)){
			userRep.deleteById(id);
			return true;
		}
		else{
		return false;
		}}
		
	


	@Override
	public User updateUser(User user) {
		return userRep.save(user);
	}

	@Override
	public User retrieveUser(int id) {
		return userRep.findById(id).get();  
		}

	
	


}
