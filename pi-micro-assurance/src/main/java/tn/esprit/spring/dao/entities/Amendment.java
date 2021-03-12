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
public class Amendment implements Serializable {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Amendment_ID")
	private int id; // Clé primaire
	
	@Temporal (TemporalType.DATE)
	private Date amendmentDate;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	Contract contract;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Sinister sinister;
	
}
