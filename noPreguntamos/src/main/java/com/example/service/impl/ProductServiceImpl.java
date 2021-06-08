package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.HangarDTO;
import com.example.dto.ProductDTO;
import com.example.entity.Hangar;
import com.example.entity.Product;
import com.example.service.HangarService;
import com.example.service.ProductService;

@Service
public class ProductServiceImpl {

	@Autowired
    private ProductService productService;
	
	@Autowired
    private HangarService hangarService;
	
    public List<ProductDTO> getProducts(){
        List<ProductDTO> productDTO = new ArrayList<ProductDTO>();
        List<Product> products = this.productService.findAll();
        for(int x=0;x<products.size();x++){
        	ProductDTO producto = new ProductDTO();
        	producto.setIdProduct(products.get(x).getProductId());
        	producto.setName(products.get(x).getName());
        	producto.setDescription(products.get(x).getDescription());
        	productDTO.add(producto);
        }
        return productDTO;
    }
    
	public List<ProductDTO> getProductsHangar() {
		List<ProductDTO> productsDTO = new ArrayList<ProductDTO>();
		List<Product> products = this.productService.findAll();
		HangarDTO hangarDTO = new HangarDTO();
		ProductDTO productDTO = new ProductDTO();
		
		for (Product product : products) {
			productDTO.setIdProduct(product.getProductId());
			productDTO.setName(product.getName());
			productDTO.setDescription(product.getDescription());
			hangarDTO.setIdHangar(product.getHangar().getIdHangar());
			hangarDTO.setName(product.getHangar().getName());
			productDTO.setHangarDTO(hangarDTO);
			productsDTO.add(productDTO);
		}
		return productsDTO;
	}
    
    //NO funciona, bbdd antigua, sin clave foranea id_hangar
    public void addProduct(ProductDTO productDTO) {
    	Product product = new Product();
    	product.setProductId(productDTO.getIdProduct());
    	product.setName(productDTO.getName());
    	product.setDescription(productDTO.getDescription());
    	productService.save(product);
    }
    
    //CON hangar
    public void addProductHangar(ProductDTO productDTO) {
		Product product = new Product();
		product.setDescription(productDTO.getDescription());
		product.setName(productDTO.getName());
		product.setProductId(productDTO.getIdProduct());
		Hangar hangar = new Hangar();
		hangar.setIdHangar(productDTO.getHangarDTO().getIdHangar());
		hangar.setName(productDTO.getHangarDTO().getName());
		List<Hangar> existeHangarLista = hangarService.findAll();
		Boolean existe=false;
		Hangar hangarExiste = null;
		for(Hangar hangarExist:existeHangarLista) {
			if(hangarExist.getIdHangar()==productDTO.getHangarDTO().getIdHangar()) {
				existe=true;
				hangarExiste = hangarExist;
				break;
			}
		}
		if(!existe) {
			Hangar hangarSave=hangarService.save(hangar);
			product.setHangar(hangarSave);
		}else {
			product.setHangar(hangarExiste);
		}
		productService.save(product);
    }
    
    public void deleteProductById(Long id) {
    	Product product = new Product();
    	product.setProductId(id);
    	productService.delete(product);
    }
}
