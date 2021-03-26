package tn.esprit.spring.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Comment_ID")
	private long id; // Clé primaire
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Comment(long id) {
		super();
		this.id = id;
	}

}
