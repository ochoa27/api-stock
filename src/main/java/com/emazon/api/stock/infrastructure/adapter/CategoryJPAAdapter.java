package com.emazon.api.stock.infrastructure.adapter;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.model.CategoryDomain;
import com.emazon.api.stock.domain.spi.ICategoryPerssistencePort;
import com.emazon.api.stock.infrastructure.entities.CategoryEntity;
import com.emazon.api.stock.infrastructure.mapper.CategoryMapper;
import com.emazon.api.stock.infrastructure.repository.ICategoryRepositrory;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CategoryJPAAdapter implements ICategoryPerssistencePort {
    private ICategoryRepositrory iCategoryRepositrory;
    @Override
    public String saveCategory(CategoryDomain categoryDomain) {
        CategoryEntity categoryEntity= CategoryMapper.domianToEntity(categoryDomain);
//        var categoriaEntity= new CategoryEntity(categoryregisterDTO.id(),categoryregisterDTO.name(),categoryregisterDTO.description());
        iCategoryRepositrory.save(categoryEntity);
        return "La categoria se guardo en la base de datos";
    }

    @Override
    public CategoryDomain getReferenceById(Long id) {
        var category= iCategoryRepositrory.getReferenceById(id);
        return CategoryMapper.EntitytoDomain(category);
    }

    @Override
    public CategoryDTO getReferenceByName(String name) {
        var category=CategoryMapper.entityToDTO(iCategoryRepositrory.findByName(name));
        return category;
    }

//        @Override
//    public Boolean getReferenceByName(String name) {
//        var category=CategoryMapper.toDTO(iCategoryRepositrory.findByName(name));
//        if (category==null){
//            return false;
//        }else{
//            return true;
//        }
//    }


}
