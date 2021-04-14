package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Claims;
import tn.esprit.spring.dao.entities.Insurer;

@Repository
public interface InsurerRepository extends JpaRepository<Insurer,Long> {

	//Insurer findInsuerById(long insurer_ID);

}
