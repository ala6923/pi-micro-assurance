package tn.esprit.spring.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entities.Claims;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.repository.ClaimRepository;
import tn.esprit.spring.repository.InsuredRepository;
@Service
public class ClaimsService implements IClaimsService {
	@Autowired
	ClaimRepository clRep;
	
	
	
	
	
	@Autowired
	InsuredRepository insRep;
	@Override
	public long SENDClaim(Claims claim, long insuredId) {
		// TODO Auto-generated method stub
		
		
		Insured ins = insRep.findById(insuredId);
		claim.setInsured(ins);
	    Calendar calendar = Calendar.getInstance();
	    claim.setDateClaim(calendar.getTime());
	    
	    clRep.save(claim);	
		return claim.getId();
		
		
	}

	@Override
	public List<String> retrieveAllClaims() {
		// TODO Auto-generated method stub
		
		List<String>	Claims =clRep.ViewClaims();
		return Claims;
		
	}

	@Override
	public List<String> retrieveNewClaims() {
		// TODO Auto-generated method stub
		List<String>	Claims =clRep.ViewNewClaims();
		return Claims;
		
	}

	@Override
	public List<Claims> getListCliamsLastXDays(int xDays) {
		// TODO Auto-generated method stub
		return null;
	}

}
