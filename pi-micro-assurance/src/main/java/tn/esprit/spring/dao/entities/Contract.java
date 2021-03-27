package tn.esprit.spring.dao.entities;


import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contract implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Contract_ID")
	private Long id; // Clé primaire
	
	
	@Column(name="ContractType")
	@Enumerated(EnumType.STRING)
	private Category category;
	
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
	public Contract(Long id, Category category, Date signDate, Date deadLineDate, String police, double payedAmount,
			double reminingAmount, double netPremiuim, double totalPemium, String status, double discount, double tax,
			double comission, double reInsurancePart, String qRCode, Insurer insurer, Insured insured,
			Set<Payment> payments, Set<Product> products, Set<Amendment> amendments) {
		super();
		this.id = id;
		this.category = category;
		this.signDate = signDate;
		this.deadLineDate = deadLineDate;
		Police = police;
		this.payedAmount = payedAmount;
		this.reminingAmount = reminingAmount;
		this.netPremiuim = netPremiuim;
		this.totalPemium = totalPemium;
		this.status = status;
		this.discount = discount;
		this.tax = tax;
		this.comission = comission;
		this.reInsurancePart = reInsurancePart;
		QRCode = qRCode;
		this.insurer = insurer;
		this.insured = insured;
		this.payments = payments;
		this.products = products;
		this.amendments = amendments;
	}


	public Long getId() {
		return id;
	}


	public Category getCategory() {
		return category;
	}


	public Date getSignDate() {
		return signDate;
	}


	public Date getDeadLineDate() {
		return deadLineDate;
	}


	public String getPolice() {
		return Police;
	}


	public double getPayedAmount() {
		return payedAmount;
	}


	public double getReminingAmount() {
		return reminingAmount;
	}


	public double getNetPremiuim() {
		return netPremiuim;
	}


	public double getTotalPemium() {
		return totalPemium;
	}


	public String getStatus() {
		return status;
	}


	public double getDiscount() {
		return discount;
	}


	public double getTax() {
		return tax;
	}


	public double getComission() {
		return comission;
	}


	public double getReInsurancePart() {
		return reInsurancePart;
	}


	public String getQRCode() {
		return QRCode;
	}


	public Insurer getInsurer() {
		return insurer;
	}


	public Insured getInsured() {
		return insured;
	}


	public Set<Payment> getPayments() {
		return payments;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public Set<Amendment> getAmendments() {
		return amendments;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}


	public void setDeadLineDate(Date deadLineDate) {
		this.deadLineDate = deadLineDate;
	}


	public void setPolice(String police) {
		Police = police;
	}


	public void setPayedAmount(double payedAmount) {
		this.payedAmount = payedAmount;
	}


	public void setReminingAmount(double reminingAmount) {
		this.reminingAmount = reminingAmount;
	}


	public void setNetPremiuim(double netPremiuim) {
		this.netPremiuim = netPremiuim;
	}


	public void setTotalPemium(double totalPemium) {
		this.totalPemium = totalPemium;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public void setTax(double tax) {
		this.tax = tax;
	}


	public void setComission(double comission) {
		this.comission = comission;
	}


	public void setReInsurancePart(double reInsurancePart) {
		this.reInsurancePart = reInsurancePart;
	}


	public void setQRCode(String qRCode) {
		QRCode = qRCode;
	}


	public void setInsurer(Insurer insurer) {
		this.insurer = insurer;
	}


	public void setInsured(Insured insured) {
		this.insured = insured;
	}


	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	public void setAmendments(Set<Amendment> amendments) {
		this.amendments = amendments;
	}


	
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
