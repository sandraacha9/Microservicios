package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class HangarDTO {

	@JsonProperty("id_hangar")
	private int idHangar;
	@JsonProperty("name")
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
