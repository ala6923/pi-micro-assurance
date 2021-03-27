package tn.esprit.spring.service;

import java.util.*;

import tn.esprit.spring.dao.entities.Contract;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.dao.entities.Insurer;
import tn.esprit.spring.dao.entities.Product;

public interface IContractService {
	
	Contract GenerateContract(Insured isd,Insurer inr,Product p);// gener un contrat sans signature 
	Contract signContract(Insured isd,Insurer inr, Contract c);// signature electronique 
	void deleteContract(Contract c);
	void UpdateContract(Contract c);
	List<Contract> findInsuredContract(Insured Ind);
	List<Contract> findInsurerContract(Insured Inr);
	
}
