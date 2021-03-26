package tn.esprit.spring.repository;
import tn.esprit.spring.dao.entities.Claims;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claims,Long>{

}
