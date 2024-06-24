package com.example.FinalProject.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddNewUsersAccountRequest {
    @NotEmpty(message = "Please enter a name for the account")
    private String accountName;

    @NotEmpty(message = "please enter a province")
    private String province;

    @NotEmpty(message = "Please enter a country")
    private String country;

    @NotEmpty(message = "Please enter your full address")
    private String address;

    @NotEmpty(message = "please enter a mail")
    private String email;
    @NotEmpty(message = "please enter a password")
    private String password;

    private String accountType;


}
