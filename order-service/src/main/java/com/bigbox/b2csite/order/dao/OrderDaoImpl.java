package com.bigbox.b2csite.order.dao;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.bigbox.b2csite.order.model.entity.OrderEntity;

public class OrderDaoImpl implements OrderDao {

	@Override
	public List<OrderEntity> findOrdersByCustomer(long customerId) throws ServiceException {
		return null;
	}

}
