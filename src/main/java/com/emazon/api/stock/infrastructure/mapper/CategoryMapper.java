package com.emazon.api.stock.infrastructure.mapper;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.model.CategoryDomain;
import com.emazon.api.stock.infrastructure.entities.CategoryEntity;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {


    public static CategoryDTO entityToDTO(CategoryEntity categoryEntity) {
        if (categoryEntity == null) {
            return null;
        }
        CategoryDTO categoryDatesDTO = new CategoryDTO(categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getDescription());
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

    public static CategoryDomain EntitytoDomain(CategoryEntity categoryEntity) {
        if (categoryEntity == null) {
            return null;
        }
        CategoryDomain categoryDomain = new CategoryDomain(categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getDescription());
        return categoryDomain;
    }

    public static List<CategoryDomain> CategoryEntityListToCategoryDomainList(List<CategoryEntity> categoryEntityList) {
        if (categoryEntityList == null) {
            return null;
        } else {
            List<CategoryDomain> categoryDomainList = new ArrayList<CategoryDomain>();
//            for(int i=0;i<=categoryEntityList.size();i++){
//                categoryDomainList.add(new CategoryDomain(categoryEntityList.get(i).getId(), categoryEntityList.get(i).getName(),categoryEntityList.get(i).getDescription()));
//
//            for(int i=0;i<=categoryEntityList.size();i++){
//                categoryDomainList.add(EntitytoDomain(categoryEntityList.get(i)));
//            }
//
            for (CategoryEntity entity : categoryEntityList) {
                categoryDomainList.add(EntitytoDomain(entity));

            }
            return categoryDomainList;
        }


    }
}
