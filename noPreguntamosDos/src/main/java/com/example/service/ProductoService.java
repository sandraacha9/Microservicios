package com.example.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Producto;

@Repository
@Transactional
public interface ProductoService extends JpaRepository<Producto, Long>{

}
