package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Comment_ID")
	private long id; // Clé primaire
	
	@Column(columnDefinition = "text")
	private String text;
	
	@Temporal(TemporalType.DATE)
	private Date date_creation;
	
	@Temporal(TemporalType.DATE)
	private Date date_lastModified;
	
	@JsonIgnore
	@ManyToOne 
	private Item item ;
	
	@ManyToOne
	private Insured insured;

    public Comment(){
    	
    }

	public Comment(long id, String text, Date date_creation, Date date_lastModified) {
		super();
		this.id = id;
		this.text = text;
		this.date_creation = date_creation;
		this.date_lastModified = date_lastModified;
	}

	public Comment(String text, Date date_creation, Date date_lastModified) {
		super();
		this.text = text;
		this.date_creation = date_creation;
		this.date_lastModified = date_lastModified;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Date getDate_lastModified() {
		return date_lastModified;
	}

	public void setDate_lastModified(Date date_lastModified) {
		this.date_lastModified = date_lastModified;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}
	

}