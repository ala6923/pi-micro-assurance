package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contract implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Contract_ID")
	private int id; // Clé primaire
	
	@Column(name="ContractType")
	private String ContractType;
	
	@Temporal (TemporalType.DATE)
	private Date signDate;
	
	@Temporal (TemporalType.DATE)
	private Date deadLineDate;
	
	@Column(name="ContractPolice")
	private String Police;
	
	@Column(name="payedAmount")
	private double payedAmount;
	
	@Column(name="reminingAmount")
	private double reminingAmount;
	
	@Column(name="netPremium")
	private double netPremiuim;
	
	@Column(name="totalPemium")
	private double totalPemium;
	
	@Column(name="ContractStatus")
	private String status;
	
	@Column(name="discount")
	private double discount;
	
	@Column(name="tax")
	private double tax;
	
	@Column(name="comission")
	private double comission;
	
	@Column(name="reInsurancePart")
	private double reInsurancePart;
	
	@Column(name="QRCode")
	private String QRCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Insurer insurer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Insured insured;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Payment> payments;
	
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Product> products;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Amendment> amendments;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
