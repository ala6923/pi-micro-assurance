package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{

}
