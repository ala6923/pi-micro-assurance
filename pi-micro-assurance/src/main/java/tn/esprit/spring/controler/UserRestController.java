package tn.esprit.spring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dao.entities.User;
import tn.esprit.spring.service.UserServiceInterface;

@RestController
@Secured(value={"ROLE_ADMIN"})
public class UserRestController {
	@Autowired
	UserServiceInterface us;
	@PostMapping("/add-user")
	@ResponseBody
	public User addUser(@RequestBody User u) {
	User user = us.addUser(u);
	return user;

	}
	@DeleteMapping("/remove-user/{user-id}")
	@ResponseBody
	public void deleteUser(@PathVariable("user-id") int id) {
	us.deleteUser(id);
	}
	@PutMapping("/modify-user")
	@ResponseBody
	public User modifyUser(@RequestBody User user) {
	return us.updateUser(user);
	}
	@GetMapping("/retrieve-user/{user-id}")
	@ResponseBody
	public User retrieveUser(@PathVariable("user-id") int id) {
	return us.retrieveUser(id);
	}
	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<User> retrieveAllUsers() {
	List<User> list = us.retrieveAllUsers();
	return list;
	}}

