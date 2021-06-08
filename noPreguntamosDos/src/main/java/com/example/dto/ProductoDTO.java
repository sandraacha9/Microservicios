package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class ProductoDTO {

	@JsonProperty("product_id")
	private Long idProduct;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("id_hangar")
	private HangarDTO hangarDTO;

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HangarDTO getHangarDTO() {
		return hangarDTO;
	}

	public void setHangarDTO(HangarDTO hangarDTO) {
		this.hangarDTO = hangarDTO;
	}

}
