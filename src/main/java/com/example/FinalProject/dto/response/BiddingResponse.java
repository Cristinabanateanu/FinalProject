package com.example.FinalProject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class BiddingResponse {

        private String auctionTitle;
        private String usersAccountName;
        private Double amount;


}


