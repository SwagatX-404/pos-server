package com.swg.payload.dto;

import com.swg.model.Store;
import lombok.Builder;
import lombok.Data;

//Data Transfer Object for Category entity(DTO for Category)
@Data
@Builder
public class CategoryDTO {



    private Long id;

    private String name;


   // private Store store;

    private Long storeId;

}
