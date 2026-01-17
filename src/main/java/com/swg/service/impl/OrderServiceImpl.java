package com.swg.service.impl;

import com.swg.domain.OrderStatus;
import com.swg.domain.PaymentType;
import com.swg.payload.dto.OrderDTO;
import com.swg.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) throws Exception {
        return null;
    }

    @Override
    public OrderDTO getOrderById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<OrderDTO> getOrdersByBranch(Long branchId, Long customerId, Long cashierId, PaymentType paymentType, OrderStatus status) throws Exception {
        return List.of();
    }

    @Override
    public List<OrderDTO> getOrderByCashier(Long cashierId) {
        return List.of();
    }

    @Override
    public void deleteOrder(Long id) throws Exception {

    }

    @Override
    public List<OrderDTO> getTodayOrdersByBranch(Long branchId) throws Exception {
        return List.of();
    }

    @Override
    public List<OrderDTO> getOrdersByCustomerId(Long customerId) throws Exception {
        return List.of();
    }

    @Override
    public List<OrderDTO> getTop5RecentOrdersByBranchId(Long branchId) throws Exception {
        return List.of();
    }
}
