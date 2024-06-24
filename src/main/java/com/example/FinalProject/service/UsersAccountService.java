package com.example.FinalProject.service;

import com.example.FinalProject.dto.request.AddNewUsersAccountRequest;
import com.example.FinalProject.dto.request.UpdateUsersAccountRequest;
import com.example.FinalProject.dto.response.UsersAccountResponse;
import com.example.FinalProject.entity.Auction;
import com.example.FinalProject.entity.UsersAccount;

import java.util.List;

public interface UsersAccountService {
    List<UsersAccountResponse> getAllUsersAccounts();
    UsersAccountResponse getUsersAccountsById(Integer id);
    UsersAccountResponse addNewUserAccount(AddNewUsersAccountRequest addUserAccountRequest);
    void updateUsersAccount(Integer id, UpdateUsersAccountRequest updateUsersAccountRequest);
    void deleteUsersAccount(Integer id);
    public void addAuctionToWatchlist(Integer auction);
    List<Auction> getWatchlist();

}
