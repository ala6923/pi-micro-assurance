package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Arrangment implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Arrangment_ID")
	private int id; // Clé primaire
	
	@Temporal (TemporalType.DATE)
	@Column(name="arrangmentDate")
	private Date arrangmentDate;
	
	@Column(name="expertCost")
	private int expertCost;
	
	@Column(name="franchise")
	private String franchise;
	
	@Column(name="indemnity")
	private String indemnity;
	
	@Column(name="arrangmentMethod")
	private String arrangmentMethod;
	
	@Column(name="amountArranged")
	private int amountArranged;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Sinister sinister;
	
	
	
	
	
	
	
	
	
	

}
