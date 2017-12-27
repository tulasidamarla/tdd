package com.bigbox.b2csite.order.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.bigbox.b2csite.order.dao.OrderDao;
import com.bigbox.b2csite.order.model.domain.OrderSummary;
import com.bigbox.b2csite.order.model.entity.OrderEntity;
import com.bigbox.b2csite.order.model.transformer.OrderEntityToOrderSummaryTransformer;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = null;
	private OrderEntityToOrderSummaryTransformer transformer = null;
	
	@Override
	public List<OrderSummary> getOrderSummary(long customerId) throws ServiceException{
		List<OrderSummary> resultList = new ArrayList<>();
		try {
			List<OrderEntity> orderEntityList = this.orderDao.findOrdersByCustomer(customerId);
			for(OrderEntity entity: orderEntityList) {
				OrderSummary summary = transformer.transform(entity);
				resultList.add(summary);
			}
			
		}catch(Exception e) {
			throw new ServiceException("Exception occurred while fetching orders");
		}
		return resultList;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public OrderEntityToOrderSummaryTransformer getTransformer() {
		return transformer;
	}

	public void setTransformer(OrderEntityToOrderSummaryTransformer transformer) {
		this.transformer = transformer;
	}

}
