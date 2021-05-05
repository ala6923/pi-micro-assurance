package tn.esprit.spring.dao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Item_ID")
	private int id; // Clé primaire
	
	@Column
	private String title;
	
	@Column(columnDefinition = "text")
	private String description;
	
	@Temporal (TemporalType.DATE)
	private Date date_pub;
	
	@Temporal (TemporalType.DATE)
	private Date date_lastModified;
	
	@ManyToOne 
	Admin admin ;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL , mappedBy="item")
	private List< Comment > comments;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL , mappedBy="item")
	private List< Vote > votes;
	
	public Item() {
		
	}

	public Item(int id, String title, String description, Date date_pub, Date date_lastModified) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date_pub = date_pub;
		this.date_lastModified = date_lastModified;
	}

	public Item(String title, String description, Date date_pub, Date date_lastModified) {
		super();
		this.title = title;
		this.description = description;
		this.date_pub = date_pub;
		this.date_lastModified = date_lastModified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_pub() {
		return date_pub;
	}

	public void setDate_pub(Date date_pub) {
		this.date_pub = date_pub;
	}

	public Date getDate_lastModified() {
		return date_lastModified;
	}

	public void setDate_lastModified(Date date_lastModified) {
		this.date_lastModified = date_lastModified;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
		/////nice
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
