package org.ejemplo.microservicios.core.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.ejemplo.microservicios.core.dto.OrderDto;
import org.ejemplo.microservicios.core.service.OrdersService;
import org.ejemplo.microservicios.core.service.TaxService;
import org.ejemplo.microservicios.data.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    /* FILTROS CON JAVA < 8*/

    @GetMapping(value="/searchbyfirstletter/{letter}")
    public List<OrderDto> searchOrdersByFirstLetter(@PathVariable char letter) {
        List<OrderDto> orders = this.ordersService.getOrders();

        List<OrderDto> result = new ArrayList<OrderDto>();
        for(int x=0;x<orders.size();x++){
            if(letter == orders.get(x).getDescription().charAt(0)){
                result.add(orders.get(x));
            }
        }

        return result;
    }

    /*FILTROS CON JAVA 8*/
    @GetMapping(value="/searchbyfirstletterstream/{letter}")
    public List<OrderDto> searchOrdersByFirstLetterStream(@PathVariable char letter) {
        List<OrderDto> orders = this.ordersService.getOrders();

        return orders.stream()
                .filter((order) -> letter == order.getDescription().charAt(0))
                .collect(Collectors.toList());
    }

    @GetMapping(value="/distinct")
    public List<OrderDto> searchDistinctOrders() {
        List<OrderDto> orders = this.ordersService.getOrders();

        return orders.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    @GetMapping(value="/skip/{rows}")
    public List<OrderDto> searchAfterXOrders(@PathVariable Integer rows) {
        List<OrderDto> orders = this.ordersService.getOrders();

        return orders.stream()
                .skip(rows)
                .collect(Collectors.toList());
    }

    @GetMapping(value="/limit/{rows}")
    public List<OrderDto> searchOnlyXOrders(@PathVariable Integer rows) {
        List<OrderDto> orders = this.ordersService.getOrders();

        return orders.stream()
                .limit(rows)
                .collect(Collectors.toList());
    }

    /*MAPEOS CON JAVA8*/

    /**
     *
     * Get orders with taxes by country.
     *
     * @return
     * @throws NoDataException
     */
    @GetMapping(value="/{country}/taxes/get")
    public List<OrderDto> getOrdersByCountryWithTaxes(@PathVariable String country) {
        List<OrderDto> orders = this.ordersService.getOrders();

        final Double taxes = TaxService.getTaxesByCountry(country);
        TaxService taxService = (price) -> price*taxes;
        return orders.stream()
                .filter((order) -> order.getCountry().getName().equals(country))
                .map((order) -> {
                    order.setPrice(taxService.calculateTaxes(order.getPrice()));
                    return order;
                }).collect(Collectors.toList());
    }
    
    /**
     * 
     * Get all orders with taxes.
     * 
     * @return
     */
    @GetMapping(value="/taxes/get")
    public List<OrderDto> getOrdersWithTaxes(){
    	List<OrderDto> spain = this.getOrdersByCountryWithTaxes("ES");
    	List<OrderDto> uk = this.getOrdersByCountryWithTaxes("UK");
    	List<OrderDto> usa = this.getOrdersByCountryWithTaxes("USA");
    	
    	Stream<List<OrderDto>> multiListOrders = Stream.of(
                spain,
                uk,
                usa
        );
    	
    	return multiListOrders.flatMap(ordenes -> ordenes.stream()).collect(Collectors.toList());
    }

    /*REDUCION CON JAVA8*/
    /**
     *
     * Get all the orders with taxes(National and international)
     *
     * @return
     * @throws NoDataException
     */
    @GetMapping(value="/count")
    public long countOrder() {
        List<OrderDto> orders = this.ordersService.getOrders();
        return orders.stream()
                .count();
    }

}
