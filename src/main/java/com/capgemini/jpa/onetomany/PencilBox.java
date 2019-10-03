package com.capgemini.jpa.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pencilBox")
public class PencilBox {
	
	@Id
	@Column
	private int boxId;
	@Column
	private String boxName;
	
	@OneToMany(mappedBy = "pencilBox")
	 private List<Pencil> pencils ;
	
	public List<Pencil> getPencils() {
		return pencils;
	}
	public void setPencils(List<Pencil> pencils) {
		this.pencils = pencils;
	}
	public int getBoxId() {
		return boxId;
	}
	public void setBoxId(int boxId) {
		this.boxId = boxId;
	}
	public String getBoxName() {
		return boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	@Override
	public String toString() {
		return "PencilBox [boxId=" + boxId + ", boxName=" + boxName + ", pencils=" + pencils + "]";
	}
	
	
}
