package tn.esprit.spring.repository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Insured;

@Repository
public interface InsuredRepository {

	Insured findById(long insuredId);

}
