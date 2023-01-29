package com.dariuszboc.bookshop.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private String fullName;

    private String address;

    private String email;

    private String phoneNumber;

    private String role;

}
