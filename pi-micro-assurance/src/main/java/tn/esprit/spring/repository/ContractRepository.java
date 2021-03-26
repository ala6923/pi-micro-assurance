package tn.esprit.spring.repository;

import org.springframework.stereotype.Repository;
import tn.esprit.spring.dao.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long>{

}

