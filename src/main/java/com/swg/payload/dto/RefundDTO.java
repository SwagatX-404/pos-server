package com.swg.payload.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swg.domain.PaymentType;
import com.swg.model.Branch;
import com.swg.model.Order;
import com.swg.model.ShiftReport;
import com.swg.model.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefundDTO {


    private Long id;


    private OrderDTO order;
    private  Long orderId;

    private  String reason;

    private Double amount;


    //private ShiftReport shiftReport;
    private Long shiftReportId;


    private UserDto cashier;
    private String cashierName;


    private BranchDTO branch;
    private Long branchId;

    private PaymentType paymentType;
    private LocalDateTime createdAt;

}
