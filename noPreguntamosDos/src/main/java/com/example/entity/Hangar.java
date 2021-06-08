package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hangar", schema = "products_hangar")
public class Hangar {

	@Id
	@Column(name="id_hangar")
	private int idHangar;
	
	@Column(name="name")
	private String name;

	public int getIdHangar() {
		return idHangar;
	}

	public void setIdHangar(int idHangar) {
		this.idHangar = idHangar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
