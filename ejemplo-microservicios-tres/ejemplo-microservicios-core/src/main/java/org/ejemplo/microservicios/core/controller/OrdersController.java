package org.ejemplo.microservicios.core.controller;

import java.util.List;

import org.ejemplo.microservicios.core.dto.OrderDto;
import org.ejemplo.microservicios.core.service.OrdersService;
import org.ejemplo.microservicios.data.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jorge.sanchez on 06/06/2018.
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping(value="/get")
    public List<OrderDto> getOrders() {
        return this.ordersService.getOrders();
    }
    
    @PostMapping(value="/create")
    public void  addOrders(@RequestBody OrderDto orderDto) {
    	this.ordersService.addOrder(orderDto);
    }

}
