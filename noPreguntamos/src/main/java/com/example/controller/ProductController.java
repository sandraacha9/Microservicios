package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductDTO;
import com.example.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
    private final ProductServiceImpl productServiceImpl;

	public ProductController(ProductServiceImpl productoServiceImpl) {
		this.productServiceImpl = productoServiceImpl;
	}
	
	//SIN hangar
    @GetMapping(value="/getProducts")
    public List<ProductDTO> getProducts() {
        return this.productServiceImpl.getProducts();
    }
    
    //CON hangar
    @GetMapping(value="/getProductsHangar")
    public List<ProductDTO> getProductos() {
        return this.productServiceImpl.getProductsHangar();
    }
    
    //NO funciona, bbdd antigua, sin clave foranea id_hangar
    @PostMapping(value="/addProduct")
    public void  addProduct(@RequestBody ProductDTO productDTO) {
    	this.productServiceImpl.addProduct(productDTO);
    }
    
    //CON hangar
    @PostMapping(value="/addProductHangar")
    public void  addProductHangar(@RequestBody ProductDTO productDTO) {
    	this.productServiceImpl.addProductHangar(productDTO);
    }
    
    @GetMapping(value="/searchFirstLetter/{letter}")
    public ProductDTO searchOrdersByFirstLetterStream(@PathVariable char letter) {
        //List<ProductDTO> products = this.productServiceImpl.getProducts(); //SIN hangar
    	List<ProductDTO> products = this.productServiceImpl.getProductsHangar(); //CON hangar

        return products.stream()
                .filter((ordenation) -> letter == ordenation.getName().charAt(0))
                .map((ordenation) -> {
                	ordenation.setName(ordenation.getName().toUpperCase());
                	return ordenation;
                })
                .reduce((x,y) -> x.getName().length()>y.getName().length() ? x : y)
                .get();
    }
    
    @GetMapping(value="/deleteById/{id}")
    public void deleteProductById(@PathVariable Long id) {
        this.productServiceImpl.deleteProductById(id);
    }
}
