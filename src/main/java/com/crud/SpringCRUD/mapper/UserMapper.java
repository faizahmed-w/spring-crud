package com.crud.SpringCRUD.mapper;


import com.crud.SpringCRUD.ENUM.Status;
import com.crud.SpringCRUD.dto.UserRequestDTO;
import com.crud.SpringCRUD.dto.UserResponseDTO;
import com.crud.SpringCRUD.entity.User;

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
        UserResponseDTO userResponseDTO = new UserResponseDTO(user.getUserId(),
                user.getUsername(),
                user.getAge(),
                user.getAddress(),
                user.getCreatedAt(),
                user.getUpdatedAt());
        return userResponseDTO;
    }

    public static void updateUser(UserRequestDTO newUserRequestDTO, User existingUser) {
        if (newUserRequestDTO.getUsername() != null) {
            existingUser.setUsername(newUserRequestDTO.getUsername());
        }
        if (newUserRequestDTO.getPassword() != null) {
            existingUser.setPassword(newUserRequestDTO.getPassword());
        }
        if (newUserRequestDTO.getAge() != null) {
            existingUser.setAge(newUserRequestDTO.getAge());
        }
        if (newUserRequestDTO.getAddress() != null) {
            existingUser.setAddress(newUserRequestDTO.getAddress());
        }
    }



}
