package tn.esprit.spring.repository;
import tn.esprit.spring.dao.entities.Claims;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claims,Long>{

	//@Query("SELECT * FROM T_Claims c WHERE u.role= ?1")
	@Query("SELECT * FROM Claims ")
	List<Claims> ViewClaims();
	
	//@Query("SELECT * FROM Claims c WHERE c.status=0") 
	//List<Claims> ViewNewClaims();
	
	@Query("SELECT c FROM Claims c WHERE c.id= ?1") 
	Claims ViewClaimById(Long id);
	@Modifying
    @Query("delete c FROM Claims c WHERE c.id= :id")
    void DeleteClaim(@Param("id") Long id);
	
	@Modifying
    @Query("update Claims c set c.status = :Status where c.id = :id")
    Claims UpdateClaimStatus(@Param("stauts") int status,@Param("id") Long id);
	/*@Modifying
	@Query(value = "INSERT INTO T_Claims (firstName, lastName, role) VALUES (:fn, :ln,:role)",nativeQuery = true)
	void insertClaim(@Param("fn") String fn, @Param("ln") Integer ln, @Param("role");
	Integer role);*/
	@Query("delete c FROM Claims c u WHERE c.dateClaim<= :dateClaim")
    void DeleteOldClaims(@Param("dateClaim") Date dateClaim);
	
	
}
