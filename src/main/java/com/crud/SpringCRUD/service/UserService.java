package com.crud.SpringCRUD.service;

import com.crud.SpringCRUD.dto.UserRequestDTO;
import com.crud.SpringCRUD.dto.UserResponseDTO;
import com.crud.SpringCRUD.entity.User;
import com.crud.SpringCRUD.mapper.UserMapper;
import com.crud.SpringCRUD.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Without DTO:
//    public User createUser(User user) {
//        user.setStatus(Status.ACTIVE);
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUpdatedAt(LocalDateTime.now());
//        return userRepository.save(user);
//    }

    //With DTO:
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = UserMapper.userRequestDtoToUserEntity(userRequestDTO);
        user = userRepository.save(user);
        return UserMapper.userEntityToUserResponseDto(user);
    }

    public User getUserEntity(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found with ID : " + userId));
    }

    public UserResponseDTO getUserById(Long userId) {
        User user = getUserEntity(userId);
        return UserMapper.userEntityToUserResponseDto(user);
    }

    public UserResponseDTO updateUserById(Long userId, UserRequestDTO newUserRequestDTO) {
        User existingUser = getUserEntity(userId);
        UserMapper.updateUser(newUserRequestDTO, existingUser);
        User saved = userRepository.save(existingUser);
        return UserMapper.userEntityToUserResponseDto(saved);
    }

    public UserResponseDTO deleteUserById(Long userId) {
        User existingUser = getUserEntity(userId);
        UserResponseDTO userResponseDTO = UserMapper.userEntityToUserResponseDto(existingUser);
        userRepository.deleteById(userId);
        return userResponseDTO;
    }

    public List<UserResponseDTO> getAllUser() {
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for(User user : userList){
            UserResponseDTO userResponseDTO = UserMapper.userEntityToUserResponseDto(user);
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }



}
