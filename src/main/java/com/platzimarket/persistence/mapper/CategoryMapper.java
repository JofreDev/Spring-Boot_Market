package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.Category;
import com.platzimarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

// Componente de tipo spring
@Mapper(componentModel = "spring") // La clase es un mapeador
public interface CategoryMapper {

    // Son varios
    /* Donde la fuente es "idCategoria" (haciendo referencia a la entidad)
     * entonces lo lleve a "categoryId"
     */

    @Mappings({
            // Se va definiendo un a uno los atributos a homologar
            @Mapping(source = "idCategoria",
                    target = "categoryId"
            ),
            @Mapping(source = "descripcion",
                    target = "category"
            ),
            @Mapping(source = "estado",
                    target = "active"
            )
    })
        // Convertimos una "entidad Categoria" a un Category
    Category toCategory(Categoria categoria);

    // Proceso contrario
        // Convertims un "Category" a una entidad Categoria

    @InheritInverseConfiguration // -> Le indica que la conversión es invversa a la anterior
    /* El proceso es de "Category" a Categoria por lo que
       se le señala que atributo ignoramos
     */
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);


}
