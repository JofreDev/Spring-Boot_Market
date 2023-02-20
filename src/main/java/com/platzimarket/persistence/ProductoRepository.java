package com.platzimarket.persistence;

import com.platzimarket.persistence.crud.ProductoCrudRespository;
import com.platzimarket.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

/* La interface ProductoCrudRepository al extender
de CrudRepository nos facilita todas las operaciones de la base de datos.
*/

public class ProductoRepository {

    private ProductoCrudRespository productoCrudRespository;

    // Se crea método que recupera una lista de productos.

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRespository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRespository.findByIdCategoria(idCategoria);
    }

    public List<Producto> getByCategoriaAndOrder(int idCategoria){
        return productoCrudRespository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){

        return productoCrudRespository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
