package org.ejemplo.microservicios.core;

import org.ejemplo.microservicios.core.service.OrdersService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {
	
	@Autowired
	OrdersService ordersService;

	@Test
	public void getOrders() {
		Assert.assertNotNull(this.ordersService.getOrders());
	}

}
