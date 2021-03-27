package tn.esprit.spring.dao.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Product_ID")
	private long id; // Clé primaire
	
	
	
	@Column(name="category")
	@Enumerated(EnumType.STRING)
	private Category category ;
	
	
	@Column(name="productScoring")
	private int productScoring;
	public Product(int id, Category category, int productScoring) {
		super();
		this.id = id;
		this.category = category;
		this.productScoring = productScoring;
	}


	public long getId() {
		return id;
	}


	public Category getCategory() {
		return category;
	}


	public int getProductScoring() {
		return productScoring;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public void setProductScoring(int productScoring) {
		this.productScoring = productScoring;
	}


}

