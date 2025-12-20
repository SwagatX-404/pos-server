package com.swg.payload.dto;

import com.swg.domain.StoreStatus;
import com.swg.model.StoreContact;
import com.swg.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoreDTO {


    private Long id;

    private  String brand;

    private UserDto storeAdmin;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String description;

    private  String storeType;

    private StoreStatus status;

    private StoreContact contact;


}
