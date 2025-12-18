package com.crud.neutron.mapper;


import com.crud.neutron.ENUM.Status;
import com.crud.neutron.dto.UserRequestDTO;
import com.crud.neutron.dto.UserResponseDTO;
import com.crud.neutron.entity.User;

import java.time.LocalDateTime;

public class UserMapper {
    public static User userRequestDtoToUserEntity(UserRequestDTO userRequestDTO){
        User user = new User();
        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(userRequestDTO.getPassword());
        user.setAge(userRequestDTO.getAge());
        user.setAddress(userRequestDTO.getAddress());
        user.setStatus(Status.ACTIVE);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return user;
    }

    public static UserResponseDTO userEntityToUserResponseDto(User user){
        return null;
    }
}
