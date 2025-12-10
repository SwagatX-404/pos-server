package com.swg.mapper;

import com.swg.model.User;
import com.swg.payload.dto.UserDto;

public class UserMapper {


    public static UserDto toDTO(User saveduser) {

        UserDto userDto = new UserDto();

        userDto.setId(saveduser.getId());
        userDto.setFullName(saveduser.getFullName());
        userDto.setEmail(saveduser.getEmail());
        userDto.setRole(saveduser.getRole());
        userDto.setCreatedAt(saveduser.getCreatedAt());
        userDto.setUpdatedAt(saveduser.getUpdatedAt());
        userDto.setLastLogin(saveduser.getLastLogin());
        userDto.setPhone(saveduser.getPhone());

        return userDto;
    }
}
