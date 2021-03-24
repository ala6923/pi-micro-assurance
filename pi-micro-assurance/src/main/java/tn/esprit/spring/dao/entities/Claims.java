package tn.esprit.spring.dao.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Claims implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Claims_ID")
	private int id; // Clé primaire
	
	@Column(name="claimsDescription")
	private String description;
	
	@Column(name="claimsStatus")
	private int status;
	public Claims(int id, String description, int status, Insured insured) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.insured = insured;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public int getStatus() {
		return status;
	}

	public Insured getInsured() {
		return insured;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	
	@ManyToOne(cascade = CascadeType.ALL)
	Insured insured;

}
