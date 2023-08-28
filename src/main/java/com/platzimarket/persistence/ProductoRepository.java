package com.platzimarket.persistence;

import com.platzimarket.domain.dto.Product;
import com.platzimarket.domain.repository.ProductRepository;
import com.platzimarket.persistence.crud.ProductoCrudRespository;
import com.platzimarket.persistence.entity.Producto;
import com.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/* La interface ProductoCrudRepository al extender
de CrudRepository nos facilita todas las operaciones de la base de datos.
*/

// Clase que se encarga de interactuar con la BD
@Repository
public class ProductoRepository implements ProductRepository {

    private final ProductoCrudRespository productoCrudRespository;

    private final ProductMapper productMapper;

    public ProductoRepository(ProductoCrudRespository productoCrudRespository, ProductMapper productMapper) {
        this.productoCrudRespository = productoCrudRespository;
        this.productMapper = productMapper;
    }

    // Se crea método que recupera una lista de productos.

    @Override
    public List<Product> getAll(){

        return productMapper.toProducts (
                (List<Producto>) productoCrudRespository.findAll()
        );
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {

        return Optional.ofNullable(productMapper.toProducts(productoCrudRespository.findByIdCategoria(categoryId)));
    }

    @Override
    public Optional<List<Product>> getScaseProducts(int quantity) {

        Optional<List<Producto>> productos = productoCrudRespository.
                                             findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map( p -> ( productMapper.toProducts(p))) ;
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return Optional.ofNullable(
                productMapper.toProduct((productoCrudRespository.findById(productId)).get())
        );
    }

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(
                productoCrudRespository.save(productMapper.toProducto(product))
        );
    }

    public List<Producto> getByCategoriaAndOrder(int idCategoria){
        return productoCrudRespository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }


    @Override
    public void delete(int productId){
        productoCrudRespository.deleteById(productId);
    }
}
