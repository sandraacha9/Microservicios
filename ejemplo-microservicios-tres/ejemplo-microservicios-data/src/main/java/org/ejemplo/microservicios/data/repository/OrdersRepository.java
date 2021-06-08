package org.ejemplo.microservicios.data.repository;

import javax.transaction.Transactional;

import org.ejemplo.microservicios.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jorge.sanchez on 07/06/2018.
 */
@Repository
@Transactional
public interface OrdersRepository extends JpaRepository<Order, Long>{

}
