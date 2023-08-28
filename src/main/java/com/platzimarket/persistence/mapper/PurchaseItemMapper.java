package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.dto.Purchase;
import com.platzimarket.domain.dto.PurchaseItem;
import com.platzimarket.persistence.entity.Compra;
import com.platzimarket.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class}) // se llama a PurchaseItemMapper. Así sea solo para ignorarlo
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"), // el Id del source es compuesto
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true), // ignoramos relación producto
            @Mapping(target = "producto", ignore = true), // ignoramos relación compra
            @Mapping(target = "id.idCompra", ignore = true) // Ignoramos el id compra de la llave compuesta y por ende necesitamos el mapper '{PurchaseItemMapper.class}'
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}
