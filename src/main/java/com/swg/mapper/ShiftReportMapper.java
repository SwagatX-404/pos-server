package com.swg.mapper;

import com.swg.model.Order;
import com.swg.model.Product;
import com.swg.model.Refund;
import com.swg.model.ShiftReport;
import com.swg.payload.dto.OrderDTO;
import com.swg.payload.dto.ProductDTO;
import com.swg.payload.dto.RefundDTO;
import com.swg.payload.dto.ShiftReportDTO;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;


public class ShiftReportMapper {



    public static ShiftReportDTO toDTO(ShiftReport entity) {

        return  ShiftReportDTO.builder()
                .id(entity.getId())
                .shiftEnd(entity.getShiftEnd())
                .shiftStart(entity.getShiftStart())

                .totalSales(entity.getTotalSales())
                .totalRefunds(entity.getTotalRefunds())
                .totalOrders(entity.getTotalOrders())

                .netSales(entity.getNetSales())

                .cashier(UserMapper.toDTO(entity.getCashier()))
                .cashierId(entity.getCashier().getId())
                .branchId(entity.getBranch().getId())

                .recentOrders(mapOrders(entity.getRecentOrders()))
                .topSellingProducts(mapProducts(entity.getTopSellingProducts()))
                .refunds(mapRefunds(entity.getRefunds()))
                .paymentSummaries(entity.getPaymentSummaries())
                .build();
    }

    private static List<RefundDTO> mapRefunds(List<Refund> refunds) {

        if(refunds == null || refunds.isEmpty())
        { return null; }

        return refunds.stream()
                .map(RefundMapper::toDTO)
                .collect(Collectors.toList());
    }

    private static List<ProductDTO> mapProducts(List<Product> topSellingProducts) {

        if( topSellingProducts == null || topSellingProducts.isEmpty())
        { return null; }

        return topSellingProducts.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());

    }
    private static List<OrderDTO> mapOrders(List<Order> recentOrders) {

        if(recentOrders == null || recentOrders.isEmpty())
        { return null; }

        return recentOrders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }
}
