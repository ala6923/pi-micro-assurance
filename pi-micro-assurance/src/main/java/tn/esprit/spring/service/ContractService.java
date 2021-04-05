package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.dao.entities.Category;
import tn.esprit.spring.dao.entities.Contract;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.dao.entities.Insurer;
import tn.esprit.spring.dao.entities.Product;
import tn.esprit.spring.dao.entities.Sinister;
import tn.esprit.spring.repository.SinisterRepository;
import tn.esprit.spring.repository.ContractRepository;
public class ContractService implements IContractService {
	@Autowired
	SinisterRepository Sr;
	@Autowired
	ContractRepository cntR;
	
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
			//Treatment
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
		cntR.delete(c);

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
	public List<Contract> findInsuredContracts(Insured ind) {
		List<Contract> ls=cntR.findAll();
		List<Contract> retoure = new ArrayList<Contract>();
		for(Contract itr :ls)
		{
		
		if (itr.getInsured().equals(ind))
			retoure.add(itr);
		}
		
		
		
		return retoure;
	}

	@Override
	public List<Contract> findInsurerContracts(Insured inr) {
				List<Contract> ls=cntR.findAll();
				List<Contract> retoure = new ArrayList<Contract>();
				for(Contract itr :ls)
				{
				
				if (itr.getInsurer().equals(inr))
					retoure.add(itr);
				}
				
				
				
				return retoure;
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
	public List<Contract> viewContractsByCategory(Category cat) {
		List<Contract> ls=cntR.findAll();
		List<Contract> retoure = new ArrayList<Contract>();
		for(Contract itr :ls)
		{
		
		if (itr.getCategory().equals(cat))
			retoure.add(itr);
		}
		
		
		
		return retoure;
	}
	
	
	

}
