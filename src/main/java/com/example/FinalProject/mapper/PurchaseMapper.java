package com.example.FinalProject.mapper;

import com.example.FinalProject.dto.request.AddPurchaseRequest;
import com.example.FinalProject.dto.request.UpdatePurchaseRequest;
import com.example.FinalProject.dto.response.PurchaseResponse;
import com.example.FinalProject.entity.Bidding;
import com.example.FinalProject.entity.Purchase;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {
    public PurchaseResponse fromPurchaseEntity(Purchase purchase){
        PurchaseResponse purchaseResponse=new PurchaseResponse();

        purchaseResponse.setAuctionTitle(purchase.getAuction().getTitle());
        purchaseResponse.setUsersAccountName(purchase.getUsersAccount().getAccountName());
        purchaseResponse.setAmount(purchase.getAmount());

        return purchaseResponse;
    }

    public Purchase fromAddPurchaseRequest(AddPurchaseRequest addPurchaseRequest){
        Purchase purchase = new Purchase();
        purchase.setAmount(addPurchaseRequest.getAmount());

         return purchase;
    }

    public Purchase fromUpdatePurchaseRequest(Purchase target, UpdatePurchaseRequest updatePurchaseRequest){

        target.setAmount(updatePurchaseRequest.getAmount());
        return target;
    }

}
