package com.example.FinalProject.dto.response;

import com.example.FinalProject.entity.Auction;
import com.example.FinalProject.entity.UsersAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResponse {

    private String auctionTitle;
    private String usersAccountName;
    private Double amount;

}