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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_Payment")
public class Payment implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Payment_ID")
	private Long id; // Clé primaire
	
	@Column(name="paymentCode")
	private String paymentCode;
	
	@Temporal (TemporalType.DATE)
	private Date paymentDate;
	
	@Column(name="amountPayed")
	private double amountPayed;
	
	@Column(name="paymentMethod")
	private String paymentMethod;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy="payment")
	private Contract contract;
	
	public Payment(Long id, String paymentCode, Date paymentDate, double amountPayed, String paymentMethod,
			Contract contract) {
		super();
		this.id = id;
		this.paymentCode = paymentCode;
		this.paymentDate = paymentDate;
		this.amountPayed = amountPayed;
		this.paymentMethod = paymentMethod;
		this.contract = contract;
	}

	public Long getId() {
		return id;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public double getAmountPayed() {
		return amountPayed;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public Contract getContract() {
		return contract;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public void setAmountPayed(double amountPayed) {
		this.amountPayed = amountPayed;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	
	
	
	
	
	
	
	
	
	

}
