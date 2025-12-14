package com.swg.service.impl;

import com.swg.configuration.JwtProvider;
import com.swg.exceptions.UserException;
import com.swg.model.User;
import com.swg.repository.UserRepository;
import com.swg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public User getUserFromJwtToken(String token) throws UserException {

        String email = jwtProvider.getEmailFromToken(token);
        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new UserException("Invalid token..!");
        }
        return user;
    }

    @Override
    public User getCurrentUser() throws UserException {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new UserException("user not found..!");
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) throws UserException {

        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new UserException("user not found..!");
        }
        return user;
    }


    //Problem with exception
    @Override
    public User getUserById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(
                ()-> new Exception("user not found...!")
        );
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
