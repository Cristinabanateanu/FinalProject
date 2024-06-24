package com.example.FinalProject.repository;

import com.example.FinalProject.entity.UsersAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersAccountRepository  extends JpaRepository<UsersAccount, Integer> {
    Optional<UsersAccount> findByAccountName(String username);
    Optional<UsersAccount> findByAccountEmail(String email);

}

