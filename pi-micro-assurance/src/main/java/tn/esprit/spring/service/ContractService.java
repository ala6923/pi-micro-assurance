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
import tn.esprit.spring.repository.InsurerRepository;
import tn.esprit.spring.repository.ProductRepository;
public class ContractService implements IContractService {
	@Autowired
	SinisterRepository Sr;
	@Autowired
	ContractRepository cntR;
	@Autowired
	ProductRepository prdR;
	@Autowired
	InsurerRepository inrR;
	
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
	public List<Contract> findContractByCategory(Category categorie) {
		List<Contract> ls=cntR.findAll();
		List<Contract> retoure=new ArrayList<Contract>();
		for(Contract itr :ls)
		{
		
		if(itr.getCategory().equals(categorie))
			retoure.add(itr);
			
		}
		return retoure;
	}


	@Override
	public double calculateNetPrimium(Contract c,Date ppBiginigReferenceYear,Date ppEndReferenceYear, List<Product> panier) {
		double purePrimium=0;
		double Commission;
		double FNG;
		double netprim;
		for(Product prod :panier){
			Insurer ins=inrR.findInsuerById(prod.getInsurer_ID());
			purePrimium+=CalculatePurePrimium(ppBiginigReferenceYear,ppBiginigReferenceYear,prod.getCategory(),ins);
			
			
		}
		switch(c.getInsured().getSegment()){
		/*case Risky1:
			c.setDi;
			break;
		case Risky2:
			break;*/
		case Risky3:
			purePrimium+=purePrimium*0.01;
			break;
		case Risky4:
			purePrimium+=purePrimium*0.02;
			break;
		case Risky5:
			purePrimium+=purePrimium*0.04;
			break;
		/*case fraud:
			
			break;*/
		default:
			break;
		
		}
		//c.setInsured(insured);
		Commission=c.getComission()*purePrimium/100;
		FNG=c.getNetMangamentFees()*purePrimium/100;
		netprim=purePrimium+Commission+FNG ;
		c.setComission(Commission);
		c.setNetMangamentFees(FNG);
		c.setNetPremiuim(netprim);
		
		return netprim;
	}

	@Override
	public Contract calculateTotalPrimuim(Contract c,double tax) {
		double totalPrimium=0;
		switch(c.getInsured().getSegment()){
		case Risky1:
			c.setDiscount(c.getNetPremiuim()*0.04);
			break;
		case Risky2:
			c.setDiscount(c.getNetPremiuim()*0.02);
			break;
		
		default:
			c.setDiscount(0);
			break;
		
		}
		totalPrimium=c.getNetPremiuim()+tax-c.getDiscount();
		c.setTotalPemium(totalPrimium);
		return c;
	}

	@Override
	public Contract generateContract(Insured insured, List<Product> product) {
		// TODO Auto-generated method stub
		//calcule du tax
		double tax;
		Contract c =new Contract();
		c.setInsured(insured);
	
		c.setPayedAmount(0);
		//c.setInsurer(produ);
		
		
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
