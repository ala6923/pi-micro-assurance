package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.el.parser.ParseException;

import tn.esprit.spring.dao.entities.User;
import tn.esprit.spring.service.UserServiceInterface;

@RunWith(SpringRunner.class)
@SpringBootTest
class PiMicroAssuranceApplicationTests  {
	
	@Autowired
	UserServiceInterface us;
	
	
	
	

	@Test
	void contextLoads() throws ParseException {
    us.retrieveAllUsers();             
		User u2= new User("aa","bb");
		us.addUser(u2);
		User u = new User( "abderrahim" , "makina" ,193587 ,"abderrahim.makina@esprit.tn", 2424210 ,"48ariensoghra","rahMak" ,"azerty123","activated");
		us.addUser(u);
	}

}
