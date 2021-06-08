package com.example.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;

@Repository
@Transactional
public interface ProductService extends JpaRepository<Product, Long>{

}
