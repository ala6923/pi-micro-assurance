package tn.esprit.spring.repository;
import tn.esprit.spring.dao.entities.Claims;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claims,Long>{

	
	@Query("SELECT * FROM T_Claims ")
	List<String> ViewClaims();
	
	@Query("SELECT * FROM User u WHERE status=0") 
	List<String> ViewNewClaims();

}
