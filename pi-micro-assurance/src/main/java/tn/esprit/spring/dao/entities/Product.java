package tn.esprit.spring.dao.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Product_ID")
	private int id; // Clé primaire
	
	
	
	@Column(name="category")
	@Enumerated(EnumType.STRING)
	private Category category ;
	
	
	@Column(name="productScoring")
	private int productScoring;

}

