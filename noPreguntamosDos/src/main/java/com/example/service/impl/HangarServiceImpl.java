package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.HangarDTO;
import com.example.entity.Hangar;
import com.example.service.HangarService;

@Service
public class HangarServiceImpl {

	@Autowired
	private HangarService hangarService;

	public List<HangarDTO> getHangares() {
		List<HangarDTO> hangarDTO = new ArrayList<HangarDTO>();
		List<Hangar> hangares = this.hangarService.findAll();
		for (int x = 0; x < hangares.size(); x++) {
			HangarDTO hangar = new HangarDTO();
			hangar.setIdHangar(hangares.get(x).getIdHangar());
			hangar.setName(hangares.get(x).getName());
			hangarDTO.add(hangar);
		}
		return hangarDTO;
	}

	public void addProductos(HangarDTO hangarDTO) {
		Hangar hangar = new Hangar();
		hangar.setIdHangar(hangarDTO.getIdHangar());
		hangar.setName(hangarDTO.getName());
		hangarService.save(hangar);
	}
}
