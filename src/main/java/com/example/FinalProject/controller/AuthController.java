package com.example.FinalProject.controller;

import com.example.FinalProject.dto.request.AddNewUsersAccountRequest;
import com.example.FinalProject.dto.request.SignInRequest;
import com.example.FinalProject.dto.response.SignInResponse;
import com.example.FinalProject.mapper.UsersAccountMapper;
import com.example.FinalProject.security.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
     private final UsersAccountMapper usersAccountMapper;
    public AuthController(AuthService authService, AuthenticationManager authenticationManager, UsersAccountMapper usersAccountMapper) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.usersAccountMapper = usersAccountMapper;
    }


    @PostMapping("/final_project/v1/register")
    public ResponseEntity<Void> registerAdmin(@RequestBody @Valid AddNewUsersAccountRequest addNewUsersAccountRequest)
    {
        authService.getUserByEmail(addNewUsersAccountRequest.getEmail());
        authService.registerUser(addNewUsersAccountRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/final_project/v1/signin")
    public ResponseEntity<SignInResponse> signIn(@RequestBody @Valid SignInRequest signInRequest)
    {
        SignInResponse response = authService.signIn(signInRequest);

        return ResponseEntity.ok().body(response);
    }


}