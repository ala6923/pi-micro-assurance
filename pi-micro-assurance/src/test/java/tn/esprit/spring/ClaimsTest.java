package tn.esprit.spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.dao.entities.Claims;
import tn.esprit.spring.repository.ClaimRepository;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@DataJpaTest
public class ClaimsTest {
	@Autowired
	private ClaimRepository cr;
	

}
