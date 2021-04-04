package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.dao.entities.Category;
import tn.esprit.spring.dao.entities.Contract;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.dao.entities.Insurer;
import tn.esprit.spring.dao.entities.Product;
import tn.esprit.spring.dao.entities.Sinister;
import tn.esprit.spring.repository.SinisterRepository;
import tn.esprit.spring.repository.ContractRepository;
public class ContractService implements IContractService {
	SinisterRepository Sr;
	
	public double CalculatePurePrimium(Date BeginigOfYear,Date endDate,Category cat,Insurer ins){
		List<Sinister> ls=Sr.findAll();
		int i=0;
		
		double totalCost=0;
		for(Sinister itr :ls)
		{
		
		if (itr.getSinisterDate().after(BeginigOfYear)&&itr.getSinisterDate().before(endDate)&&(itr.getContract().getInsurer().equals(ins))&&(itr.getContract().getCategory().equals(cat)))
			totalCost+=itr.getSinisterCost();
			i++;
		}
		
		
		return totalCost/i;
	} 

	@Override
	public double calculateNetPrimium(Insured insured, List<Product> panier) {
		double netPrimium=0; 
		
		for(Product prod :panier){
		switch(prod.getCategory()){
		case income_insurance:
			
			break;
		case life_insurance:
			//traitement
			break;
		case agriculture_insurance:
			
			break;
		case health_insurance:
			break;
		default:
			break ;
		
		
		
		}
		}
		return netPrimium ;
	}

	@Override
	public Contract calculateTotalPrimuim(Contract c) {
		
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public Contract generateContract(Insured insured, Insurer insurer, List<Product> product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contract signContract(Insured insured, Insurer insurer, Contract contract) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void archiveContract(Contract c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteContract(Contract c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateContract(Contract c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unsignContract(Contract c) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contract> findInsuredContracts(Insured Ind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contract> findInsurerContracts(Insured Inr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void evaluteContract(Contract c) {
		// TODO Auto-generated method stub

	}

	@Override
	public int CountContractsBetween(String EndDate_ddmmyyyy, String BiginingDate_yymmdd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contract> viewContractsByCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
