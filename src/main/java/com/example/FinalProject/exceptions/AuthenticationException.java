package com.example.FinalProject.exceptions;

import org.springframework.security.core.Authentication;

public class AuthenticationException extends RuntimeException{
    public AuthenticationException(String message) {
        super(message);
    }
}
