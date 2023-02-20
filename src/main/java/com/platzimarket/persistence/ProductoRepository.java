package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {

    private ProductoCrudRespository productoCrudRespository;

    // Se crea método que recupera una lista de productos.

    public List<Producto> getAll(){
        return productoCrudRespository.findAll();
    }
}
