package com.example.demo.service;

import com.example.demo.dto.userDTO;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo ;

     @Autowired
    private ModelMapper modelMapper;

   public List<userDTO>getAllUser(){
    List<User>userList=userRepo.findAll();
    return modelMapper.map(userList, new TypeToken<List<userDTO>>(){}.getType());
     }

     public userDTO saveUser(userDTO userDTO){
       userRepo.save(modelMapper.map(userDTO, User.class));
       return userDTO;
     }

     public userDTO updateUser(userDTO userDTO){
       userRepo.save(modelMapper.map(userDTO,User.class));
       return userDTO;
     }

     public String deleteUser(userDTO userDTO) {

       userRepo.delete(modelMapper.map(userDTO,User.class));
       return "User deleted";

   }
}
