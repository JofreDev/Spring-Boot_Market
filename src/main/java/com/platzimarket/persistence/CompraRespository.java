package com.platzimarket.persistence;


import com.platzimarket.domain.dto.Purchase;
import com.platzimarket.domain.repository.PurchaseRespository;
import com.platzimarket.persistence.crud.CompraCrudRespository;
import com.platzimarket.persistence.entity.Compra;
import com.platzimarket.persistence.mapper.PurchaseItemMapper;
import com.platzimarket.persistence.mapper.PurchaseMapper;

import java.util.List;
import java.util.Optional;

public class CompraRespository implements PurchaseRespository {

    private final CompraCrudRespository compraCrudRespository;

    private final PurchaseMapper purchaseMapper;


    public CompraRespository(CompraCrudRespository compraCrudRespository, PurchaseMapper purchaseMapper) {
        this.compraCrudRespository = compraCrudRespository;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>) compraCrudRespository.findAll()) ;
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        // El map solo es para tomar la lista si existe
        // Si encontró una lista solo devolveria un item lista que ya se castea a lista de purchase
        return compraCrudRespository.findByIdCliente(clientId)
                .map(c -> (purchaseMapper.toPurchases(c))) ;
    }

    @Override
    public Purchase save(Purchase purchase) {

        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        // Para este tipo de operaciones se debe aclarar en la entidad
        // que hay un grupo (en este caso de productos)
        // que se van a guardar en forma de cascada
        return purchaseMapper.toPurchase(compraCrudRespository.save(compra));
    }
}
