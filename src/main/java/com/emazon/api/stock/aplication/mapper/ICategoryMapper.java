package com.emazon.api.stock.aplication.mapper;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.model.CategoryDomain;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {

    @Mappings({
            @Mapping(source = "name" , target = "name"),
            @Mapping(source = "description" , target = "description"),

    })
    @InheritInverseConfiguration //la anotacion me permite mappear inversamente tambien
    CategoryDomain categoryDTOToCategoryDomain(CategoryDTO categoryDTO);


}
