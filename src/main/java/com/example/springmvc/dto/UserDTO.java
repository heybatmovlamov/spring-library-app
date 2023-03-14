package com.example.springmvc.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    @NotBlank(message = "Enter your email")
    @Email(message = "Enter a valid email address")
    String email;
    @NotBlank(message = "Enter your password")
    String password;
    @NotBlank(message = "Re-enter your password")
    String repeatPassword;
}
