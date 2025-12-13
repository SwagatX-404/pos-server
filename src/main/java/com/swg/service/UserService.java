package com.swg.service;

import com.swg.exceptions.UserException;
import com.swg.model.User;

import java.util.List;

public interface UserService {

    User getUserFromJwtToken(String token) throws UserException;
    User getCurrentUser();
    User getUserByEmail(String email);
    User getUserById(Long id);
    List<User> getAllUser();



}
