package tn.esprit.spring.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Contract;
import tn.esprit.spring.dao.entities.Sinister;


@Repository
public interface SinisterRepository extends CrudRepository<Sinister, Integer> {
	
	
	Sinister findByDeclarationDateBetween(Date from,Date to );
	
	Sinister findBySinisterDateBetween(Date from,Date to );
	
	Sinister findByContract(Contract contract ) ; 
	

}
