package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.HangarDTO;
import com.example.dto.ProductoDTO;
import com.example.entity.Producto;
import com.example.service.ProductoService;

@Service
public class ProductoServiceImpl {

	@Autowired
	private ProductoService productoService;

	public List<ProductoDTO> getProductos() {
		List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
		List<Producto> productos = this.productoService.findAll();
		HangarDTO hangarDTO = new HangarDTO();
		ProductoDTO productoDTO = new ProductoDTO();
		
		for (Producto producto : productos) {
			productoDTO.setIdProduct(producto.getProductId());
			productoDTO.setName(producto.getName());
			productoDTO.setDescription(producto.getDescription());
			hangarDTO.setIdHangar(producto.getHangar().getIdHangar());
			hangarDTO.setName(producto.getHangar().getName());
			productoDTO.setHangarDTO(hangarDTO);
			productosDTO.add(productoDTO);
		}
		return productosDTO;
	}

	public void addProductos(ProductoDTO productoDTO) {
		Producto producto = new Producto();
		producto.setProductId(productoDTO.getIdProduct());
		producto.setName(productoDTO.getName());
		producto.setDescription(productoDTO.getDescription());
		productoService.save(producto);
	}
}
