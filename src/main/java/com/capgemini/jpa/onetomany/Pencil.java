package com.capgemini.jpa.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pencil")
public class Pencil {
	@Id
	@Column
	private int pencilId;
	@Column
	private String color;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "boxId", nullable = false)
	private PencilBox pencilBox ;

	public int getPencilId() {
		return pencilId;
	}

	public void setPencilId(int pencilId) {
		this.pencilId = pencilId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public PencilBox getPencilBox() {
		return pencilBox;
	}

	public void setPencilBox(PencilBox pencilBox) {
		this.pencilBox = pencilBox;
	}

	@Override
	public String toString() {
		return "Pencil [pencilId=" + pencilId + ", color=" + color + ", pencilBox=" + pencilBox + "]";
	}

}
