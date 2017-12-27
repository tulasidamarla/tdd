package com.bigbox.b2csite.order.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoAssertionError;

import com.bigbox.b2csite.order.dao.OrderDao;
import com.bigbox.b2csite.order.model.domain.OrderSummary;
import com.bigbox.b2csite.order.model.entity.OrderEntity;
import com.bigbox.b2csite.order.model.transformer.OrderEntityToOrderSummaryTransformer;

public class OrderServiceImplTest {
	
	private static final long CUSTOMER_ID = 1L;
	
	@Mock
	private OrderDao mockOrderDao;
	
	@Mock
	private OrderEntityToOrderSummaryTransformer mockTransformer;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_getOrderSummary_success() throws Exception{
		//setup
		OrderServiceImpl target = new OrderServiceImpl();
		
		//mock setup
		//OrderDao mockOrderDao = Mockito.mock(OrderDao.class);
		target.setOrderDao(mockOrderDao);
		//OrderEntityToOrderSummaryTransformer mockTransformer = Mockito.mock(OrderEntityToOrderSummaryTransformer.class);
		target.setTransformer(mockTransformer);
		
		//fixture setup
		OrderEntity orderEntityFixture = new OrderEntity();
		List<OrderEntity> orderEntityListFixture = new ArrayList<>();
		orderEntityListFixture.add(orderEntityFixture);
		OrderSummary orderSummaryFixture = new OrderSummary();
		
		//stub setup
		Mockito.when(mockOrderDao.findOrdersByCustomer(CUSTOMER_ID))
				.thenReturn(orderEntityListFixture);
		Mockito.when(mockTransformer.transform(orderEntityFixture))
				.thenReturn(orderSummaryFixture);
		
		//Execution
		List<OrderSummary> result = target.getOrderSummary(CUSTOMER_ID);
		
		//Verification
		
		//verify the method interactions with mocks
		Mockito.verify(mockOrderDao).findOrdersByCustomer(CUSTOMER_ID);
		Mockito.verify(mockTransformer).transform(orderEntityFixture);
		
		//verify the data
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
		Assert.assertSame(orderSummaryFixture, result.get(0));
	}
}
