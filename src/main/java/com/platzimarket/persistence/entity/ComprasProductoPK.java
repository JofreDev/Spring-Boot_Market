package com.platzimarket.persistence.entity;


/* Objetivo : Esta clase tiene como objetivo
 * hacer de llave primaria de la clase
 * CommprasProducto.
 * Esto debido a que dicha clase tiene
 * llave primaria compuesta.
 */

// Está clase no lleva @Entity
// Porque su función no es mapear

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable // Anotación para anunciar que la clase se va a embeber en otra
            // En este caso se embebe en ComprasProducto
public class ComprasProductoPK implements Serializable {

    @Column(name = "id_compra")
    private Integer idCompra;


    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
