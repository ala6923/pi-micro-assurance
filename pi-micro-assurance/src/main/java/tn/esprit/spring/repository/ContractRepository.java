package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Contract;
import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.dao.entities.Sinister;



@Repository
public interface ContractRepository extends CrudRepository<Contract, Integer> {
	
	Sinister findByInsured(Insured insured ) ; 

}
