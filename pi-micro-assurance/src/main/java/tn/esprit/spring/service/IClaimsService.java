package tn.esprit.spring.service;

import java.util.*;

import tn.esprit.spring.dao.entities.Claims;

public interface IClaimsService {
	public long SENDClaim(Claims rec,long idCust);
	public List<String> retrieveAllReclamations();
	public List<Claims> getListCliamsLastXDays(int xDays);
}
