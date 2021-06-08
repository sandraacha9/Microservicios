package org.ejemplo.microservicios.core.service;

import org.ejemplo.microservicios.core.dto.CountryDto;
import org.ejemplo.microservicios.core.dto.OrderDto;
import org.ejemplo.microservicios.data.repository.OrdersRepository;
import org.ejemplo.microservicios.data.entity.Country;
import org.ejemplo.microservicios.data.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge.sanchez on 06/06/2018.
 */
@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<OrderDto> getOrders(){
        List<OrderDto> ordersDto = new ArrayList<OrderDto>();
        List<Order> orders = this.ordersRepository.findAll();
        for(int x=0;x<orders.size();x++){
            OrderDto order = new OrderDto();
            order.setId(orders.get(x).getId());
            order.setDescription(orders.get(x).getDescription());
            order.setPrice(orders.get(x).getPrice());
            CountryDto countryDto = new CountryDto();
            countryDto.setIdCountry(orders.get(x).getCountry().getIdCountry());
            countryDto.setName(orders.get(x).getCountry().getName());
            order.setCountry(countryDto);
            ordersDto.add(order);
        }
        return ordersDto;
    }
    
    public void addOrder(OrderDto orderDto) {
    	Order order = new Order();
    	order.setId(orderDto.getId());
    	order.setDescription(orderDto.getDescription());
    	order.setPrice(orderDto.getPrice());
    	Country country = new Country();
    	country.setIdCountry(orderDto.getCountry().getIdCountry());
    	order.setCountry(country);
    	this.ordersRepository.save(order);
    }
}
