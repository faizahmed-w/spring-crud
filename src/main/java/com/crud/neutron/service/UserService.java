package com.crud.neutron.service;

import com.crud.neutron.ENUM.Status;
import com.crud.neutron.dto.UserRequestDTO;
import com.crud.neutron.dto.UserResponseDTO;
import com.crud.neutron.entity.User;
import com.crud.neutron.mapper.UserMapper;
import com.crud.neutron.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found with ID : " + userId));
    }

    public User updateUserById(Long userId, User newUser) {
        User existingUser = getUserById(userId);
        if (newUser.getUsername() != null) {
            existingUser.setUsername(newUser.getUsername());
        }
        if (newUser.getPassword() != null) {
            existingUser.setPassword(newUser.getPassword());
        }
        if (newUser.getAge() != null) {
            existingUser.setAge(newUser.getAge());
        }
        if (newUser.getAddress() != null) {
            existingUser.setAddress(newUser.getAddress());
        }
        existingUser.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(existingUser);
    }

    public User deleteUserById(Long userId) {
        User user = getUserById(userId);
        userRepository.deleteById(userId);
        return user;
    }

}
