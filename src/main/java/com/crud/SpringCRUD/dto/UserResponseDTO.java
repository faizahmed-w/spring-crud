package com.crud.SpringCRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
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

// Fields will be by default private, final
// Record will provide Getter
// By default All-Args Constructor will be provided - it will work as setter
