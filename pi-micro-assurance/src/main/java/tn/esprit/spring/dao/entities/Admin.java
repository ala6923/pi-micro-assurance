package tn.esprit.spring.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn(name = "User_ID")
public class Admin  extends User {
	
	@Column(name="Code")
	private int CodePin; 
	public int getCodePin() {
		return CodePin;
	}

	public void setCodePin(int codePin) {
		CodePin = codePin;
	}

	public Admin(int codePin) {
		super();
		CodePin = codePin;
	} 
	

	

	

	

}
