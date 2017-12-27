package com.bigbox.b2csite.order.service;

import java.util.List;

import com.bigbox.b2csite.order.model.domain.OrderSummary;

public interface OrderService {
	
	List<OrderSummary> getOrderSummary(long customerId);

}
