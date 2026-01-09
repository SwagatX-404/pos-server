package com.swg.payload.dto;

import com.swg.model.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Data Transfer Object for Category entity(DTO for Category)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {



    private Long id;

    private String name;


   // private Store store;

    private Long storeId;

}
