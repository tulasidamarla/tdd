package com.bigbox.b2csite.order.model.transformer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.bigbox.b2csite.order.model.domain.OrderSummary;
import com.bigbox.b2csite.order.model.entity.OrderEntity;
import com.bigbox.b2csite.order.model.entity.OrderItemEntity;



public class OrderEntityToOrderSummaryTransformerTest {
	
	private OrderEntityToOrderSummaryTransformer target = null;
	
	@Before
	public void setup() {
		target = new OrderEntityToOrderSummaryTransformer();
	}

	@Test
	public void test_transform_success() {
		
		String orderNumberFixture = UUID.randomUUID().toString();
		
		OrderEntity orderEntityFixture = new OrderEntity();
		orderEntityFixture.setOrderNumber(orderNumberFixture);
		
		OrderItemEntity itemEntityFixture1 = new OrderItemEntity();
		itemEntityFixture1.setQuantity(1);
		itemEntityFixture1.setSellingPrice(new BigDecimal("10.00"));
		
		OrderItemEntity itemEntityFixture2 = new OrderItemEntity();
		itemEntityFixture2.setQuantity(2);
		itemEntityFixture2.setSellingPrice(new BigDecimal("5.00"));
		
		List<OrderItemEntity> itemEntityListFixture = new ArrayList<>();
		
		itemEntityListFixture.add(itemEntityFixture1);
		itemEntityListFixture.add(itemEntityFixture2);
		
		orderEntityFixture.setOrderItemList(itemEntityListFixture);
		
		OrderSummary result=target.transform(orderEntityFixture);
		
		Assert.assertNotNull(result);
		
		Assert.assertEquals(orderNumberFixture, result.getOrderNumber());
		
		Assert.assertEquals(3, result.getItemCount());
		
		Assert.assertEquals(new BigDecimal("20.00"), result.getTotalAmount());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_transform_input_null() {
		target.transform(null);
	}
}
