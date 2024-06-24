package com.example.FinalProject.mapper;

import com.example.FinalProject.dto.request.AddNewUsersAccountRequest;
import com.example.FinalProject.dto.request.UpdateUsersAccountRequest;
import com.example.FinalProject.dto.response.SignInResponse;
import com.example.FinalProject.dto.response.UsersAccountResponse;
import com.example.FinalProject.entity.UsersAccount;
import com.example.FinalProject.security.UsersAccountDetailsImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersAccountMapper {
    final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    public UsersAccountResponse fromUsersAccountEntity(UsersAccount usersAccount) {


        UsersAccountResponse response = new UsersAccountResponse();

        response.setAccountName(usersAccount.getAccountName());
        response.setProvince(usersAccount.getProvince());
        response.setCountry(usersAccount.getCountry());
        response.setAddress(usersAccount.getAddress());
        response.setEmail(usersAccount.getAccountEmail());
        return response;
    }

    public UsersAccount fromUsersAccountRequest(AddNewUsersAccountRequest addNewUsersAccountRequest) {
        UsersAccount usersAccount = new UsersAccount();

        usersAccount.setAccountName(addNewUsersAccountRequest.getAccountName());
        usersAccount.setProvince(addNewUsersAccountRequest.getProvince());
        usersAccount.setCountry(addNewUsersAccountRequest.getCountry());
        usersAccount.setAddress(addNewUsersAccountRequest.getAddress());
        usersAccount.setAccountEmail(addNewUsersAccountRequest.getEmail());
        usersAccount.setPassword(passwordEncoder.encode(addNewUsersAccountRequest.getPassword()));
        return usersAccount;
    }

    public UsersAccount fromUsersAccountUpdateRequest(UsersAccount usersAccountTarget, UpdateUsersAccountRequest updateUsersAccountRequest) {
        usersAccountTarget.setAccountName(updateUsersAccountRequest.getAccountName());
        usersAccountTarget.setProvince(updateUsersAccountRequest.getProvince());
        usersAccountTarget.setCountry(updateUsersAccountRequest.getCountry());
        usersAccountTarget.setAddress(updateUsersAccountRequest.getAddress());
        usersAccountTarget.setAccountEmail(updateUsersAccountRequest.getEmail());
        usersAccountTarget.setPassword(updateUsersAccountRequest.getPassword());

        return usersAccountTarget;
    }

    public SignInResponse fromUsersAccountDetailsImpl(UsersAccountDetailsImpl usersAccountDetails)
    {
        SignInResponse response = new SignInResponse();

        response.setAccountName(usersAccountDetails.getUsername());
        response.setEmail(usersAccountDetails.getEmail());
        List<String> types = usersAccountDetails.getAuthorities().stream().map(a->a.getAuthority()).toList();
        response.setType(types);

        return response;
    }
}

