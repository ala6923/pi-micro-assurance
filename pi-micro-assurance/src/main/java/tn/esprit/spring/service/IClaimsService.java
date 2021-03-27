package tn.esprit.spring.service;

import java.util.*;

import tn.esprit.spring.dao.entities.Claims;


public interface IClaimsService {
	public long SENDClaim(Claims rec,long insuredId);
	public List<String> retrieveAllClaims();
	public List<String> retrieveNewClaims();
	public List<Claims> getListCliamsLastXDays(int xDays);
	
}
