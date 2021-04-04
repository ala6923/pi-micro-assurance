package tn.esprit.spring.repository;

import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Claims;
import tn.esprit.spring.dao.entities.Contract;


@Repository
public interface ContractRepository extends JpaRepository<Contract,Long>{
	@Query("SELECT * FROM Contract ")
	List<Contract> ViewContracts();
	@Query("SELECT c FROM Contract c WHERE c.id= ?1") 
	Contract ViewCotractById(Long id);
	@Modifying
	@Query("delete c FROM Contract c WHERE c.id= :id")
    void DeleteContract(@Param("id") Long id);
	//@Modifying
	//@Query("update Contract c set c.payedAmount = :payedAmount,c.reminingAmount = :reminingAmount,c.LastUpdate = :LastUpdate where c.id = :id")
	//void updatePaymentContract(@Param("payedAmount") double payedAmount,@Param("reminingAmount")double reminingAmount,@Param("LastUpdate") Date LastUpdate,@Param("id") Long id);
}

