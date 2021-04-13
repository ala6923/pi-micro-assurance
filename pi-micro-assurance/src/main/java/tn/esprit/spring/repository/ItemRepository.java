package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer>{
	
	@Query("select i from Item i where i.title = :title")
    List<Item> SearchByTitle(@Param("title") String title);
	
	@Query("SELECT i FROM Item i WHERE i.title LIKE %:title%")
	List<Item> searchByTitleLike(@Param("title") String title);
	
	@Query("SELECT i FROM Item i WHERE i.title LIKE :title%")
	List<Item> searchByTitleStartsWith(@Param("title") String title);
	
	@Query("SELECT i FROM Item i WHERE i.description LIKE %:mot%")
	List<Item> searchByDescriptionLike(@Param("mot") String mot);
	//@Query("select i FROM Item where ")
	
	@Query("SELECT i FROM Item i ORDER BY i.date_pub DESC")
	List<Item> retrieveAllOrderByDateDesc();
	
	@Query("select i from Item i where datediff(curdate(),i.date_pub)<=1")
	List<Item> findByCreatedDateLessThanOneDay();
	
	@Query("select i from Item i where datediff(curdate(),i.date_pub)<=7")
	List<Item> findByCreatedDateLessThanOneWeek();
	
	//@Query("select i from Item i where year(i.date_pub) = year(curdate()) and ((month(i.date_pub) - month(curdate)) <= 1) ")
	@Query("select i from Item i where i.date_pub BETWEEN :datemonthago AND :datenow")
	List<Item> findByCreatedDateLessThanOneMonth(@Param("datenow") Date datenow , @Param("datemonthago") Date date2);
	
	@Query("select i from Item i where ((year(i.date_pub) - year(curdate())) <= 1) ")
	List<Item> findByCreatedDateLessThanOneYear();
	
	////sort by vote
	////sort items by year map
	//// item by admin poster
	
}
