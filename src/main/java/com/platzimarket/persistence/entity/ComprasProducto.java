package com.platzimarket.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    @EmbeddedId // EmbeddedId -> Se usa cuando la llave primaria es compuesta y por lo tanto está dada por otra clase !!!
    private ComprasProductoPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

    // Configurando relación Compras - ComprasProducto

    /*
    Cuando queremos guardar en cascada debemos poner la anotación @MapsId
    porque esta anotación es la que proporciona la asignación para una
    clave primaria cuando se usa @EmbeddedId. La anotación @JoinColumn solo
    especifica que columna se relaciona a la hora trabajar con el atributo de la relación.
    */
    @ManyToOne
    @MapsId("idCompra") // Con esto ya sabe a que   pk pertenece cada uno de los productos que está en una compra
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false,updatable = false)
    private Producto producto;

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
