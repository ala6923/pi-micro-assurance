package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.el.parser.ParseException;

import tn.esprit.spring.dao.entities.Insured;
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
		Insured u2= new Insured();
		u2.setName("name");
		u2.setFirstname("firstname");
		us.addUser(u2);
		
	}

}
