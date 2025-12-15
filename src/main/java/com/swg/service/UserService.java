package com.swg.service;

import com.swg.exceptions.UserException;
import com.swg.model.User;

import java.util.List;

public interface UserService {

    User getUserFromJwtToken(String token) throws UserException;
    User getCurrentUser() throws UserException;
    User getUserByEmail(String email) throws UserException;
    User getUserById(Long id) throws Exception;
    List<User> getAllUser();



}
