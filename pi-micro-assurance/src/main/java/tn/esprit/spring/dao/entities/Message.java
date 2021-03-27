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
public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Message_ID")
	private long id; // Clé primaire
	
	@Column(name="subject")
	private String subject;
	public Message(long id, String subject, String body, Date sendingDate, String status) {
		super();
		this.id = id;
		this.subject = subject;
		this.body = body;
		this.sendingDate = sendingDate;
		this.status = status;
	}
	@Column(name="body")
	private String body;
	
	@Temporal (TemporalType.DATE)
	private Date sendingDate;
	
	@Column(name="status")
	private String status;
	
	

	public long getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

	public Date getSendingDate() {
		return sendingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setSendingDate(Date sendingDate) {
		this.sendingDate = sendingDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
