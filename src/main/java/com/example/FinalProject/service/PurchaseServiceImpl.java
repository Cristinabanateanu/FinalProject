package com.example.FinalProject.service;


import com.example.FinalProject.dto.request.AddPurchaseRequest;
import com.example.FinalProject.dto.request.UpdatePurchaseRequest;
import com.example.FinalProject.dto.response.PurchaseResponse;
import com.example.FinalProject.entity.Auction;
import com.example.FinalProject.entity.Purchase;
import com.example.FinalProject.entity.UsersAccount;
import com.example.FinalProject.exceptions.NotFoundException;
import com.example.FinalProject.exceptions.PurchaseNotFoundException;
import com.example.FinalProject.mapper.PurchaseMapper;
import com.example.FinalProject.repository.AuctionRepository;
import com.example.FinalProject.repository.PurchaseRepository;
import com.example.FinalProject.repository.UsersAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {


    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private UsersAccountRepository usersAccountRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;



    public List<PurchaseResponse> getAllPurchases() {
        List<Purchase> purchases = purchaseRepository.findAll();

        List<PurchaseResponse> purchaseResponseList = purchases.stream().map(element->purchaseMapper.fromPurchaseEntity(element)).collect(Collectors.toList());

        return purchaseResponseList;

    }

    @Override
    public PurchaseResponse getPurchaseById(Integer id) {
        Optional<Purchase> purchaseOptional = purchaseRepository.findById(id);
        if(purchaseOptional.isPresent()){
            Purchase purchase = purchaseOptional.get();
            PurchaseResponse purchaseResponse = purchaseMapper.fromPurchaseEntity(purchase);
            return purchaseResponse;
        }else{
            throw new PurchaseNotFoundException("Purchase with id " + id + " not found");
        }
    }


    @Transactional
    public PurchaseResponse createPurchase(AddPurchaseRequest addPurchaseRequest) {

        Purchase purchase =purchaseMapper.fromAddPurchaseRequest(addPurchaseRequest);

        Optional<Auction> auctionOptional = auctionRepository.findByTitle(addPurchaseRequest.getAuctionTitle());
        Optional<UsersAccount> usersAccountOptional= usersAccountRepository.findByAccountName(addPurchaseRequest.
                getUsersAccountName());

        if(auctionOptional.isPresent() && usersAccountOptional.isPresent())
        {
            purchase.setAuction(auctionOptional.get());
            purchase.setUsersAccount(usersAccountOptional.get());
        }
        else {
            throw new NotFoundException("The user or the auction is not yet created");
        }

        purchaseRepository.save(purchase);

        PurchaseResponse purchaseResponse = purchaseMapper.fromPurchaseEntity(purchase);

        return purchaseResponse;
    }
    @Transactional

    public void updatePurchase(Integer id, UpdatePurchaseRequest updatePurchaseRequest) {
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);

        if(optionalPurchase.isPresent()) {
            Purchase purchase= purchaseMapper.fromUpdatePurchaseRequest(optionalPurchase.get(), updatePurchaseRequest);
            purchaseRepository.save(purchase);
        } else{
            throw new PurchaseNotFoundException("Purchase with id " + id + " not found");
        }

    }


     @Transactional
    public void deletePurchaseById(Integer id) {
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);

        if(optionalPurchase.isPresent()) {

            purchaseRepository.deleteById(id);
        } else{
            throw new PurchaseNotFoundException("Purchase with id " + id + " not found");
        }

    }




    @Transactional
    @Override
    public Purchase bidOnAuction(Integer auctionId, Integer userId, Integer amount)  {


       return null;
    }





    @Override
    public Purchase buyNow(Integer auctionId, Integer userId, Integer amount) throws Exception {
     return null;

    }
}




