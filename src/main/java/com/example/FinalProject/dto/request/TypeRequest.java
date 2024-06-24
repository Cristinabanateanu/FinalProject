package com.example.FinalProject.dto.request;

import com.example.FinalProject.entity.UsersAccount;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeRequest {

    private String typeName;

}
