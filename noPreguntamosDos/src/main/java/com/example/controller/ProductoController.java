package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductoDTO;
import com.example.service.impl.ProductoServiceImpl;

@RestController
@RequestMapping("/productoshangar")
public class ProductoController {

	@Autowired
    private final ProductoServiceImpl productoServiceImpl;

	public ProductoController(ProductoServiceImpl productoServiceImpl) {
		this.productoServiceImpl = productoServiceImpl;
	}
	
    @GetMapping(value="/get")
    public List<ProductoDTO> getProductos() {
        return this.productoServiceImpl.getProductos();
    }
    
    @PostMapping(value="/post")
    public void  addOrders(@RequestBody ProductoDTO productoDTO) {
    	this.productoServiceImpl.addProductos(productoDTO);
    }
}
