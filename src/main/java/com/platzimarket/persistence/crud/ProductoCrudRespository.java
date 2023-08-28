package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/* CrudRepository recibe dos parámetros :
 * Tabla y tipo de dato de la llave primaria (tabla,Tipo_dato_llave)
 * Ejemplo :
 * CrudRepository <Producto, Integer>
 */
public interface ProductoCrudRespository extends CrudRepository<Producto, Integer> {

    // En esta interfaz se desarrollan los Query Methods :

    /* Recuperar lista de productos que pertenezscan a una categoria en específico
     * Se tiene que respetar la nomenclatura Java
     * List<Producto> metodo (findByID) - atributo (IdCatgoria) (Atributo exacto entidad )
     * La siguiente query no tiene un ordenamiento definido
     */

    List<Producto> findByIdCategoria(int idCategoria);

    // ### Definiendo un ordenamiento por nombre :

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    // Ejemplo con un Query nativo !!!
/*
    @Query(value = "SELECT * FROM category WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> getByCategoria(int idCategoria);
*/
    // Los Query methods soportan operadores opcionales <> para manejo de nulos. Previene el NullExeption !
    // Se quieren recuperar los productos escasos
    // 'LessThan' indica en menor cantidad
    //'AndEstado' indica que queremos los productos activos
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
