package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

	@Query("SELECT p FROM Product p WHERE p.name_ins= :name_ins")
	List<Product> retrieveProductsByName_ins(@Param("name_ins") Name_ins name_ins);

	
	@Modifying
	@Query("update User p set p.id = :role where p. = :id")
	int updateProductStatusById(@Param("id") Id id, @Param("id1") String id1);
	
	@Modifying
	@Query(value = "INSERT INTO T_PRODUCT (id, name_ins, scale) VALUES (:i, :ns, :scale)", nativeQuery = true)
	void insertProduct(@Param("id") String id, @Param("ns") Integer ns, @Param("scale") Integer scale);
	
	
}
