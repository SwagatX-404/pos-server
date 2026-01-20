package com.swg.service.impl;

import com.swg.domain.OrderStatus;
import com.swg.domain.PaymentType;
import com.swg.mapper.OrderMapper;
import com.swg.model.*;
import com.swg.payload.dto.OrderDTO;
import com.swg.repository.OrderRepository;
import com.swg.repository.ProductRepository;
import com.swg.service.OrderService;
import com.swg.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserService userService;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;


    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) throws Exception {
        User cashier = userService.getCurrentUser();

        Branch branch = cashier.getBranch();
            if(branch==null){
                throw new Exception("Cashier is not assigned to any branch...!");
            }

            Order order = Order.builder()
                    .branch(branch)
                    .cashier(cashier)
                    .customer(orderDTO.getCustomer())
                    .paymentType(orderDTO.getPaymentType())
                    .build();

            List<OrderItem> orderItems=orderDTO.getItems().stream().map(
                    itemDto -> {
                        Product product = productRepository.findById(itemDto.getProductId())
                                .orElseThrow(
                                        () -> new EntityNotFoundException("Product not found..!")
                                );
                        return OrderItem.builder()
                                .product(product)
                                .quantity(itemDto.getQuantity())
                                .price(product.getSelligPrice()* itemDto.getQuantity())
                                .order(order)
                                .build();
                    }
            ).toList();
            double total = orderItems.stream().mapToDouble(OrderItem::getPrice).sum();
            order.setTotalAmount(total);
            order.setItems(orderItems);

            Order savedOrder = orderRepository.save(order);

        return OrderMapper.toDTO(savedOrder);
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
