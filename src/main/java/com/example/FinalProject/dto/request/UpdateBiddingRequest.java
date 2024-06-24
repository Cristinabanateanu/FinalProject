package com.example.FinalProject.dto.request;

import com.example.FinalProject.entity.Auction;
import com.example.FinalProject.entity.UsersAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateBiddingRequest {
    private String auctionTitle;
    private String usersAccountName;
    private Double amount;
}
