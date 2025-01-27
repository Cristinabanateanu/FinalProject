package com.example.FinalProject.security;

import com.example.FinalProject.entity.AccountType;
import com.example.FinalProject.entity.UsersAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsersAccountDetailsImpl implements UserDetails {

    private final UsersAccount usersAccount;
    public UsersAccountDetailsImpl(UsersAccount usersAccount) {
        this.usersAccount = usersAccount;
    }

    public UsersAccount getUsersAccount(){
        return usersAccount;
    }
    public Collection<? extends GrantedAuthority> mapTypesToGrantedAuthorities(List<AccountType> types)
    {
        Collection<? extends GrantedAuthority> authorities = types.stream()
                .map(type-> new SimpleGrantedAuthority(type.getName())).
                toList();


        return authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return mapTypesToGrantedAuthorities((List<AccountType>) usersAccount.getAccountTypes());
    }

    @Override
    public String getPassword() {
        return usersAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return usersAccount.getAccountName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail()
    {
        return usersAccount.getAccountEmail();
    }

}