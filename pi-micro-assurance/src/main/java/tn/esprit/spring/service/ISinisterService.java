package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.dao.entities.Contract;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.dao.entities.Sinister;

public interface ISinisterService {
	
	List<Sinister> retrieveAllSinisters();
	Sinister addSinister(Sinister sinister);
	 String deleteSinister(int id);
	 Sinister updateSinister(Sinister sinister);
	 Sinister retrieveSinister(int id);
	 Sinister retrieveSinisterByContract(Contract contract);

	 Sinister retrieveSinisterByDeclarationDate(Date from , Date to );
	 
	 Sinister retrieveSinisterBySinisterDate(Date from , Date to );
	 
	 Sinister declarerSinistre(Sinister sinister, Insured  insured );
	 
	 Sinister traiterSinistre(Sinister sinister , Contract contract);
	 
	 
	 

}
