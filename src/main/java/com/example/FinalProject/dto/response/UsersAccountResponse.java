package com.example.FinalProject.dto.response;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersAccountResponse {
    private String accountName;
    private String province;
    private String country;
    private String address;
    private String email;


}
