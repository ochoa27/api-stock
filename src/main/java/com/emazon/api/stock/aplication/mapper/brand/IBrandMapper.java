package com.emazon.api.stock.aplication.mapper.brand;

import com.emazon.api.stock.aplication.dto.brand.BrandDTO;
import com.emazon.api.stock.domain.model.BrandDomain;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface IBrandMapper {
    @Mappings({
            @Mapping(source = "name" , target = "name"),
            @Mapping(source = "description" , target = "description"),

    })
    @InheritInverseConfiguration//la anotacion me permite mappear inversamente tambien
    BrandDomain categoryDTOToCategoryDomain(BrandDTO brandDTO);

}
