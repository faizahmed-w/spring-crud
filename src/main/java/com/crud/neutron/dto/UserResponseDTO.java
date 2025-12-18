package com.crud.neutron.dto;

import com.crud.neutron.ENUM.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDTO {
    private Long userId;
    private String username;
    private Integer age;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

//record UserResponseDTO2(Long userId,
//                        String username,
//                        Integer age,
//                        String address,
//                        LocalDateTime createdAt,
//                        LocalDateTime updatedAt ){
//
//}
