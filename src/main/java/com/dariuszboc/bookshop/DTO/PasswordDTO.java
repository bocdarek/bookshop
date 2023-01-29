package com.dariuszboc.bookshop.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordDTO {

    private String newPassword1;

    private String newPassword2;

    private String oldPassword;
}
