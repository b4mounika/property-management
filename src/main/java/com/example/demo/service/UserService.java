package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);

    }

