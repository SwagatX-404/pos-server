package com.swg.payload.response;


import com.swg.payload.dto.UserDto;
import lombok.Data;

@Data
public class AuthResponse {


    private String jwt;
    private String message;
    private UserDto user;

}
