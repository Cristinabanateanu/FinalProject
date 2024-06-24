package com.example.FinalProject.service;
import com.example.FinalProject.dto.request.AddPurchaseRequest;
import com.example.FinalProject.dto.request.UpdatePurchaseRequest;
import com.example.FinalProject.dto.response.PurchaseResponse;
import com.example.FinalProject.entity.Purchase;

import java.util.List;

public interface PurchaseService {
    List<PurchaseResponse> getAllPurchases();

    PurchaseResponse getPurchaseById(Integer id);
    void deletePurchaseById(Integer id);
    Purchase bidOnAuction(Integer auctionId, Integer userId, Integer amount) throws Exception;

    Purchase buyNow(Integer auctionId, Integer userId, Integer amount) throws Exception;



    PurchaseResponse createPurchase(AddPurchaseRequest addPurchaseRequest);

    void updatePurchase(Integer id, UpdatePurchaseRequest updatePurchaseRequest);
}
