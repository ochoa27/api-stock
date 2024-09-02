package com.emazon.api.stock.infrastructure.mapper;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.model.CategoryDomain;
import com.emazon.api.stock.infrastructure.entities.CategoryEntity;


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

    public static CategoryEntity domainToEntity(CategoryDomain categoryDomain) {
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

//    public static Page<CategoryDomain> CategoryEntityPageToCategoryDomainPage(Page<CategoryEntity> categoryEntityPage) {
//        if (categoryEntityPage == null) {
//            return null;
//        } else {
//            Page<CategoryDomain> categoryDomainPage = new Page<CategoryDomain>() {
//            };
//            for (CategoryEntity entity : categoryEntityPage) {
//                categoryDomainPage.add(EntitytoDomain(entity));
//
//            }
//            return categoryDomainPage;
//        }
//    }
//    public static Page<CategoryDomain> CategoryEntityPageToCategoryDomainPage(Page<CategoryEntity> categoryEntityPage) {
//        if (categoryEntityPage == null) {
//            return null;
//        } else {
//            List<CategoryDomain> categoryDomainList = categoryEntityPage.stream()
//                    .map(CategoryMapper::EntitytoDomain) // Asumiendo que tienes un método de mapeo estático EntitytoDomain
//                    .collect(Collectors.toList());
//
//            // Usamos PageImpl para crear un Page<CategoryDomain> con la lista y la información de paginación
//            return new PageImpl<>(categoryDomainList, PageRequest.of(categoryEntityPage.getNumber(), categoryEntityPage.getSize()), categoryEntityPage.getTotalElements());
//        }
//    }
}
