package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dao.entities.User;



public interface UserServiceInterface {
	
	List<User> retrieveAllUsers();
	User addUser(User u);
	
	 User updateUser(User u);
	
	boolean deleteUser(int id);
	User retrieveUser(int id);

}
