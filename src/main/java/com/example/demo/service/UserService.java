package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.exception.BusinessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO register(UserDTO userDTO) throws BusinessException;
    UserDTO login(String email, String password) throws BusinessException;

    }

