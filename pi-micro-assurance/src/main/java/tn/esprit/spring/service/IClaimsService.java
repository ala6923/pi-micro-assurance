package tn.esprit.spring.service;

import java.util.*;

import tn.esprit.spring.dao.entities.Claims;


public interface IClaimsService {
	public long SendClaim(Claims rec,long insuredId);
	public List<Claims> RetrieveAllClaims();
	public List<Claims> RetrieveNewClaims();
	public List<Claims> GetListCliamsLastXDays(int xDays);
	public void DeleteClaimById(long id);
	public Claims OpenClaimById(long id);
	public int CountClaimsBetween(String EndDate_ddmmmyyyy,String BiginingDate_yymmdd);
	public void DeleteOldClaims(Date firstdate);
	
}
