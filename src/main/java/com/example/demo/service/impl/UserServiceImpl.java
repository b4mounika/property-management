package com.example.demo.service.impl;


import com.example.demo.converter.UserConverter;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;


    @Override
    public UserDTO register(UserDTO userDTO) throws BusinessException {

        Optional<UserEntity> optUe = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if (optUe.isPresent()) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXIST");
            ErrorModel.setMessage("The Email With Which You Are Trying To Register Already Exists!");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntityToDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) throws BusinessException {
        UserDTO userDTO = null;
       Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email,password);
       if(optionalUserEntity.isPresent()){
           userDTO = userConverter.convertEntityToDTO(optionalUserEntity.get());
       }else{

           List<ErrorModel> errorModelList = new ArrayList<>();
           ErrorModel errorModel = new ErrorModel();
           errorModel.setCode("INVALID_LOGIN");
           ErrorModel.setMessage("Incorrect Email or password");
           errorModelList.add(errorModel);

           throw new BusinessException(errorModelList);

       }
        return userDTO;
    }
}
