package com.platzimarket.domain.service;

import com.platzimarket.domain.dto.Purchase;
import com.platzimarket.domain.repository.PurchaseRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PurchaseRespository purchaseRespository;

    public PurchaseService(PurchaseRespository purchaseRespository) {
        this.purchaseRespository = purchaseRespository;
    }

    public List<Purchase> getAll(){
        return purchaseRespository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRespository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase){
        return purchaseRespository.save(purchase);
    }


}
