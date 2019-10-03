package com.capgemini.jpa.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "votercard")
public class VoterCard {

	@Id
	@Column
	private int vcard;
	@Column
	private String vname;
	
	// Bidirectional
	@OneToOne(mappedBy = "voterCard")
	private Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getVcard() {
		return vcard;
	}
	public void setVcard(int vcard) {
		this.vcard = vcard;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	@Override
	public String toString() {
		return "VoterCard [vcard=" + vcard + ", vname=" + vname + ", person=" + person + "]";
	}
	
}
