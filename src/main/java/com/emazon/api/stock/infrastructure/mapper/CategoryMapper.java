package com.emazon.api.stock.infrastructure.mapper;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.infrastructure.entities.CategoryEntity;

public class CategoryMapper {


    public static CategoryDTO toDTO(CategoryEntity categoryEntity) {
        if (categoryEntity == null) {
            return null;
        }
        CategoryDTO categoryDatesDTO = new CategoryDTO(categoryEntity.getId(),categoryEntity.getName(),categoryEntity.getDescription());
        return categoryDatesDTO;
    }

    public static CategoryEntity toEntity(CategoryDTO categoryregisterDTO) {
        if (categoryregisterDTO == null) {
            return null;
        }
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryregisterDTO.id());
        categoryEntity.setName(categoryregisterDTO.name());
        categoryEntity.setDescription(categoryregisterDTO.description());
        return categoryEntity;
    }
}
