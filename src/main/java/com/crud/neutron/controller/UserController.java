package com.crud.neutron.controller;

import com.crud.neutron.dto.UserRequestDTO;
import com.crud.neutron.dto.UserResponseDTO;
import com.crud.neutron.entity.User;
import com.crud.neutron.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public UserResponseDTO create(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.createUser(userRequestDTO);
    }

    @GetMapping("get/{userId}")
    public User get(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("update/{userId}")
    public User update(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUserById(userId, user);
    }

    @DeleteMapping("delete/{userId}")
    public User delete(@PathVariable Long userId) {
        return userService.deleteUserById(userId);
    }
}
