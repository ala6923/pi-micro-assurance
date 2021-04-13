package tn.esprit.spring.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dao.entities.Claims;

import tn.esprit.spring.service.IClaimsService;


@RestController
public class ClaimsController {

	
	
	@Autowired
	IClaimsService Icl;
	
	// SEND A claim : http://localhost:8081/SpringMVC/servlet/send-claim/1
		@PostMapping(value = "/send-claim/{insuredId}")
		@ResponseBody
		public long SENDRECLAMATION(@RequestBody Claims rec, @PathVariable("insuredId") long insuredId) {
	    	return	Icl.SendClaim(rec, insuredId);
	    }
		@GetMapping(value = "/retrieve-all-rec")
		@ResponseBody
		public List<Claims> getclaims() {
			
			return Icl.RetrieveAllClaims();
		}
}
