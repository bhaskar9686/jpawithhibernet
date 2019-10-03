package com.capgemini.jpa.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="person")
public class Person {
	@Id
	@Column
	private int pid;
	@Column
	private String pname;
	@Column
	private int age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vcard")
	private VoterCard voterCard;
	
	public VoterCard getVoterCard() {
		return voterCard;
	}
	public void setVoterCard(VoterCard voterCard) {
		this.voterCard = voterCard;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", age=" + age + ", voterCard=" + voterCard + "]";
	}
	
	
}
