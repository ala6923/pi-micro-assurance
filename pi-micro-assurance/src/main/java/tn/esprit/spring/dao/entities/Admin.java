package tn.esprit.spring.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn(name = "User_ID")
public class Admin  extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
