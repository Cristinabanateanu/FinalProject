package com.example.FinalProject.service;

import com.example.FinalProject.dto.request.AddBiddingRequest;
import com.example.FinalProject.dto.request.UpdateBiddingRequest;
import com.example.FinalProject.dto.response.BiddingResponse;

import java.util.List;

public interface BiddingService {
    List<BiddingResponse> getAllBiddings();
    BiddingResponse getBiddingById(Integer id);

    BiddingResponse createBidding(AddBiddingRequest addBiddingRequest);

    void updateBidding(Integer id, UpdateBiddingRequest updateBiddingRequest);

    void deleteBiddingById(Integer id);
}
