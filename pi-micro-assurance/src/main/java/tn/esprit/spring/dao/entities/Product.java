package tn.esprit.spring.dao.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity 
public class Product {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProduct;
	private Long idInsurent;
	private String nameinsurentProduct;
	private Double scoringProduct;
	private String scaleProduct;
	private Date dateCreation;
	
	
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public Long getIdInsurent() {
		return idInsurent;
	}
	public void setIdInsurent(Long idInsurent) {
		this.idInsurent = idInsurent;
	}
	public String getNameinsurentProduct() {
		return nameinsurentProduct;
	}
	public void setNameinsurentProduct(String nameinsurentProduct) {
		this.nameinsurentProduct = nameinsurentProduct;
	}
	public Double getScoringProduct() {
		return scoringProduct;
	}
	public void setScoringProduct(Double scoringProduct) {
		this.scoringProduct = scoringProduct;
	}
	public String getScaleProduct() {
		return scaleProduct;
	}
	public void setScaleProduct(String scaleProduct) {
		this.scaleProduct = scaleProduct;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	public Product() {
		super();
		
	}
	
	
	public Product(Long idInsurent, String nameinsurentProduct, Double scoringProduct, String scaleProduct,
			Date dateCreation) {
		super();
		this.idInsurent = idInsurent;
		this.nameinsurentProduct = nameinsurentProduct;
		this.scoringProduct = scoringProduct;
		this.scaleProduct = scaleProduct;
		this.dateCreation = dateCreation;
	}
	
	
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", idInsurent=" + idInsurent + ", nameinsurentProduct="
				+ nameinsurentProduct + ", scoringProduct=" + scoringProduct + ", scaleProduct=" + scaleProduct
				+ ", dateCreation=" + dateCreation + "]";
	}
	
	

}
