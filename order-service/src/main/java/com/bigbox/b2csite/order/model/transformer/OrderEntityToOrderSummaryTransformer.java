package com.bigbox.b2csite.order.model.transformer;

import java.math.BigDecimal;

import com.bigbox.b2csite.order.model.domain.OrderSummary;
import com.bigbox.b2csite.order.model.entity.OrderEntity;
import com.bigbox.b2csite.order.model.entity.OrderItemEntity;

public class OrderEntityToOrderSummaryTransformer {

	public OrderSummary transform(OrderEntity entity) {
		
		if(entity == null) {
			throw new IllegalArgumentException("entity cannot be null");
		}
		OrderSummary summary = new OrderSummary();
		summary.setOrderNumber(entity.getOrderNumber());
		int itemCount = 0;
		BigDecimal totalAmount = new BigDecimal("0.00");
		
		for(OrderItemEntity item: entity.getOrderItemList()) {
			itemCount+=item.getQuantity();
			BigDecimal quantity = new BigDecimal(item.getQuantity());
			BigDecimal itemTotal = item.getSellingPrice().multiply(quantity);
			totalAmount=totalAmount.add(itemTotal);
		}
		
		summary.setItemCount(itemCount);
		summary.setTotalAmount(totalAmount);

		return summary;
	}

}