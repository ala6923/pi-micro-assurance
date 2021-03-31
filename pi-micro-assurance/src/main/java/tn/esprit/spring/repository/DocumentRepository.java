package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Document;


@Repository
public interface DocumentRepository extends CrudRepository<Document, Integer>{

}
