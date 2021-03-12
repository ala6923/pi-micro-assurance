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
public class Payment implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Payment_ID")
	private int id; // Clé primaire
	
	@Column(name="paymentCode")
	private String paymentCode;
	
	@Temporal (TemporalType.DATE)
	private Date paymentDate;
	
	@Column(name="amountPayed")
	private double amountPayed;
	
	@Column(name="paymentMethod")
	private String paymentMethod;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Contract contract;
	
	
	
	
	
	
	
	

}
