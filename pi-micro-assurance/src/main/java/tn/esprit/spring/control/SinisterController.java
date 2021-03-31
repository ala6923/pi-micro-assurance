package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dao.entities.Sinister;
import tn.esprit.spring.service.ISinisterService;

@RestController
public class SinisterController {
	
	@Autowired
	ISinisterService IsinisterService ; 
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-sinisters
 @GetMapping("/retrieve-all-sinisters")
 @ResponseBody
	public List<Sinister> getSinisters(){
		
		List<Sinister> list = IsinisterService.retrieveAllSinisters();
		return list;
		
		
	}

}
