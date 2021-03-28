package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import tn.esprit.spring.dao.entities.Claims;
import tn.esprit.spring.repository.ClaimRepository;

@DataJpaTest
public class ClaimsTest {
	@Autowired
	private ClaimRepository cr;
	@Test
	public void creatClaim(){
		Claims cl=new Claims(1, null, 1, null);
		cr.save(cl);
		
	} 

}
