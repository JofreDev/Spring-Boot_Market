package com.platzimarket.domain.repository;

import com.platzimarket.domain.dto.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRespository {

    List<Purchase> getAll();

    Optional<List<Purchase>> getByClient(String clientId);
    
    Purchase save(Purchase purchase);
}
