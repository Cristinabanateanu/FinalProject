package com.example.FinalProject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class TypeResponse {

        private String typeName;
        private List<String> usersAccount;

    }

