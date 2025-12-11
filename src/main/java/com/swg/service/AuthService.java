package com.swg.service;

import com.swg.exceptions.UserException;
import com.swg.payload.dto.UserDto;
import com.swg.payload.response.AuthResponse;

public interface AuthService {


    AuthResponse signup(UserDto userDto) throws UserException;
    AuthResponse login(UserDto userDto) throws UserException;


}
