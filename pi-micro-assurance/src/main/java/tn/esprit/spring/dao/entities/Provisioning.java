package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Provisioning implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Provisionning_ID")
	private int id; // Clé primaire
	
	
	@Temporal (TemporalType.DATE)
	private Date startDate;
	
	@Temporal (TemporalType.DATE)
	private Date endDate;
	
	@Column(name="provisioningType")
	private String provisioningType;
	public Provisioning(int id, Date startDate, Date endDate, String provisioningType) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.provisioningType = provisioningType;
	}

	public int getId() {
		return id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getProvisioningType() {
		return provisioningType;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setProvisioningType(String provisioningType) {
		this.provisioningType = provisioningType;
	}

	
	
	
	

}
