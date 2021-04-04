package tn.esprit.spring.service;

import java.util.*;

import tn.esprit.spring.dao.entities.Contract;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.dao.entities.Insurer;
import tn.esprit.spring.dao.entities.Product;

public interface IContractService {
	
	double calculateNetPrimium(Insured insured, List<Product> panier);
	Contract calculateTotalPrimuim(Contract c);
	Contract generateContract(Insured insured,Insurer insurer, List<Product> product);// gener un contrat sans signature 
	Contract signContract(Insured insured,Insurer insurer, Contract contract);// signature electronique 
	void archiveContract(Contract c);
	void deleteContract(Contract c);
	void updateContract(Contract c);
	void unsignContract(Contract c);
	List<Contract> findInsuredContracts(Insured Ind);
	List<Contract> findInsurerContracts(Insured Inr);
	void evaluteContract(Contract c);
	List<Contract> viewContractsByCategory();
	public int CountContractsBetween(String EndDate_ddmmyyyy,String BiginingDate_yymmdd);
	
	
}
