package com.emazon.api.stock.infrastructure.mapper;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.model.CategoryDomain;
import com.emazon.api.stock.infrastructure.entities.CategoryEntity;

public class CategoryMapper {


    public static CategoryDTO entityToDTO(CategoryEntity categoryEntity) {
        if (categoryEntity == null) {
            return null;
        }
        CategoryDTO categoryDatesDTO = new CategoryDTO(categoryEntity.getId(),categoryEntity.getName(),categoryEntity.getDescription());
        return categoryDatesDTO;
    }

    public static CategoryEntity domianToEntity(CategoryDomain categoryDomain) {
        if (categoryDomain == null) {
            return null;
        }
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryDomain.getId());
        categoryEntity.setName(categoryDomain.getName());
        categoryEntity.setDescription(categoryDomain.getDescription());
        return categoryEntity;
    }

    public static CategoryDomain EntitytoDomain(CategoryEntity categoryEntity){
        if (categoryEntity == null) {
            return null;
        }
        CategoryDomain categoryDatesDTO = new CategoryDomain(categoryEntity.getId(),categoryEntity.getName(),categoryEntity.getDescription());
        return categoryDatesDTO;
    }

    public static CategoryDTO domainToDTO(CategoryDomain categoryDomain) {
        if (categoryDomain == null) {
            return null;
        }
        CategoryDTO categoryDatesDTO = new CategoryDTO(categoryDomain.getId(),categoryDomain.getName(),categoryDomain.getDescription());
        return categoryDatesDTO;
    }

    public static CategoryEntity dtoToEntity(CategoryDTO categoryDTO) {
        if (categoryDTO == null) {
            return null;
        }
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryDTO.id());
        categoryEntity.setName(categoryDTO.name());
        categoryEntity.setDescription(categoryDTO.description());
        return categoryEntity;
    }



}
