package com.emazon.api.stock.aplication.mapper.response;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.model.CategoryDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryResponseMapper {
    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "name" , target = "name"),
            @Mapping(source = "description" , target = "description"),

    })
    CategoryDTO categoryDomainToCategoryDto(CategoryDomain categoryDomain);
    List<CategoryDTO> categoryListDomainToCategoryListDto(List<CategoryDomain> categoryDomainList);
    List<CategoryDTO> toCategoryDomainToCategoryDto(List<CategoryDomain> categoryDomainList);
}
