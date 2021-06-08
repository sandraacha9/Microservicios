package org.ejemplo.microservicios.core;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.ejemplo.microservicios.core.controller.OrdersController;
import org.ejemplo.microservicios.core.dto.OrderDto;
import org.ejemplo.microservicios.core.service.OrdersService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UnitTest {

	@Mock
	OrdersService ordersService;
	
	@Before
	public void initTests() {
		List<OrderDto> orders = new ArrayList<OrderDto>();
		when(this.ordersService.getOrders()).thenReturn(orders);
	}
	
	@Test
	public void getOrders() {
		OrdersController ordersController = new OrdersController(this.ordersService);
		Assert.assertEquals(ordersController.getOrders().size(), 0);
		
	}
	
}
