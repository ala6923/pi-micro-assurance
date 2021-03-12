package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dao.entities.User;



public interface UserServiceInterface {
	
	List<User> retrieveAllUsers();
	User addUser(User u);
	 void deleteUser(String id);
	 User updateUser(User u);
	 User retrieveUser(String id);

}
