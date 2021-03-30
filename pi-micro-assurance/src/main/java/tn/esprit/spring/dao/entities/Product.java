package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Product_ID")
	private long id; // primary key 
	
	
	
	@Column(name="category")
	@Enumerated(EnumType.STRING)
	private Category category ;
	
	
	@Column(name="productScoring")
	private int productScoring;
	
	@Column(name="insurent_ID")
	private long ID;
	
	@Column(name="name_insurent")
	private String name_ins;
	
	@Column(name="Scale")
	private String scale;
	
	
	
	
	@ManyToMany (mappedBy = "product")
	private List<Product> products; 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getProductScoring() {
		return productScoring;
	}

	public void setProductScoring(int productScoring) {
		this.productScoring = productScoring;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getName_ins() {
		return name_ins;
	}

	public void setName_ins(String name_ins) {
		this.name_ins = name_ins;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Product() {
		super();
	}

	public Product(Category category, int productScoring, long iD, String name_ins, String scale) {
		super();
		this.category = category;
		this.productScoring = productScoring;
		ID = iD;
		this.name_ins = name_ins;
		this.scale = scale;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", productScoring=" + productScoring + ", ID=" + ID
				+ ", name_ins=" + name_ins + ", scale=" + scale + "]";
	} 

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


	
	
}

