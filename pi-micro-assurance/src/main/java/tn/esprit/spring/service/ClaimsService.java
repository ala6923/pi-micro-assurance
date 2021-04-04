package tn.esprit.spring.service;

import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Date;

import org.hibernate.type.CalendarDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
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
	public long SendClaim(Claims claim, long insuredId) {
		// TODO Auto-generated method stub
		
		
		Insured ins = insRep.findById(insuredId);
		claim.setInsured(ins);
	    Calendar calendar = Calendar.getInstance();
	    claim.setDateClaim(calendar.getTime());
	    
	    clRep.save(claim);	
		return claim.getId();
		
		
	}

	@Override
	public List<Claims> RetrieveAllClaims() {
		// TODO Auto-generated method stub
		
		List<Claims>	Claims =clRep.ViewClaims();
		return Claims;
		
	}

	@Override
	public List<Claims> RetrieveNewClaims() {
		// TODO Auto-generated method stub
		List<Claims>	Claims =clRep.ViewNewClaims();
		return Claims;
		
	}

	@Override
	public List<Claims> GetListCliamsLastXDays(int xDays) {
		List<Claims> claims=clRep.findAll(Sort.by(Sort.Direction.ASC, "dateClaim"));
		List<Claims> claimsDay = null ;
		int i=1;
		for(Claims c : claims ){
			claimsDay.add(c);
			
			i++;
			if(i==xDays)
				break;
		}
		return claimsDay;
		
		}
	
	

	@Override
	public void DeleteClaimById(long id){
		clRep.DeleteClaim(id);
	}

	@Override
	public Claims OpenClaimById(long id) {
		clRep.ViewClaimById(id);
		clRep.UpdateClaimStatus(1, id);
		return clRep.ViewClaimById(id);
	}

	@Override
	public int CountClaimsBetween(String EndDate_ddmmmyyyy, String BiginingDate_ddmmmyyyy) {
		// TODO Auto-generated method stub
		int claimNember=0;
		List<Claims> claims=clRep.findAll(Sort.by(Sort.Direction.ASC, "dateClaim"));
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Date datedebut=null;
		try {
			datedebut = formatter.parse(BiginingDate_ddmmmyyyy);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Date datefin=null;
		try {
			datefin = formatter1.parse(EndDate_ddmmmyyyy);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for(Claims c : claims ){
			if(c.getDateClaim().after(datedebut))
				claimNember++;
			if(c.getDateClaim().after(datefin))
				break;
		}
		
		
		return claimNember;
	}

	@Override
	public void DeleteOldClaims(Date firstdate) {
		
		 clRep.DeleteOldClaims(firstdate);
		
	}
	
	
	
}


