package com.example.FinalProject.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class UpdateUsersAccountRequest {
    private String accountName;
    private String province;
    private String country;
    private String address;
    private String accountType;

    @NotEmpty(message = "please enter an email")
    private String email;

    @NotEmpty(message = "please enter a password")
    private String password;
}
