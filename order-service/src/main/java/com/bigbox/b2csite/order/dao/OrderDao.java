package com.bigbox.b2csite.order.dao;

import java.util.List;

import com.bigbox.b2csite.order.model.entity.OrderEntity;

public interface OrderDao {
	
	List<OrderEntity> findOrdersByCustomer(long customerId);

}
