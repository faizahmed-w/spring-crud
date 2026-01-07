package com.crud.SpringCRUD.controller;

import com.crud.SpringCRUD.dto.UserRequestDTO;
import com.crud.SpringCRUD.dto.UserResponseDTO;
import com.crud.SpringCRUD.entity.User;
import com.crud.SpringCRUD.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public UserResponseDTO create(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

    @GetMapping("get/{userId}")
    public UserResponseDTO get(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("get")
    public List<UserResponseDTO> getAll(){
        return userService.getAllUser();
    }

    @PutMapping("update/{userId}")
    public UserResponseDTO update(@PathVariable Long userId, @RequestBody UserRequestDTO newUserRequestDTO) {
        return userService.updateUserById(userId, newUserRequestDTO);
    }

    @DeleteMapping("delete/{userId}")
    public UserResponseDTO delete(@PathVariable Long userId) {
        return userService.deleteUserById(userId);
    }



}
