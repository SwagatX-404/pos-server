package com.swg.payload.dto;

import com.swg.model.Branch;
import com.swg.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class InventoryDTO {

    private Long id;

    private BranchDTO branch;

    private Long branchId;
    private Long productId;

    private ProductDTO product;

    private Integer quantity;

    private LocalDateTime lastUpdated;
}
