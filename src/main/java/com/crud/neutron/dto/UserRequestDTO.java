package com.crud.neutron.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UserRequestDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private Integer age;

    @NotBlank
    private String address;
}


//OR
//record UserRequestDTO2(String username, String password, Integer age, String address){
//
//}

// Fields will be by default private, final
// Record will provide Getter
