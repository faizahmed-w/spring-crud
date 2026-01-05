package com.crud.SpringCRUD.dto;

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
