package com.example.demo.controller;

import com.example.demo.dto.userDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //මේ class එක API එකක්
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class UserController {

    @Autowired //Object එක create කරලා inject කරන්න
    private UserService userService;

    @GetMapping("/getuser") //GET request handle කරන්න
    public List<userDTO> getUser(){
        return userService.getAllUser();
    }

    @PostMapping("/adduser") //POST request handle කරන්න
    public userDTO saveUser(@RequestBody userDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateuser")
    public userDTO updateUser(@RequestBody userDTO userDTO ){
     return userService.updateUser(userDTO);
    }

    @DeleteMapping("deleteuser")
    public String deleteUser(@RequestBody userDTO userDTO){
       return userService.deleteUser(userDTO);
    }
}
