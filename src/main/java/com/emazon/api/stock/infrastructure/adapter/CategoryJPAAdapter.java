package com.emazon.api.stock.infrastructure.adapter;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.spi.ICategoryPerssistencePort;
import com.emazon.api.stock.infrastructure.entities.CategoryEntity;
import com.emazon.api.stock.infrastructure.mapper.CategoryMapper;
import com.emazon.api.stock.infrastructure.repository.ICategoryRepositrory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryJPAAdapter implements ICategoryPerssistencePort {
    private ICategoryRepositrory iCategoryRepositrory;
    @Override
    public String saveCategory(CategoryDTO categoryregisterDTO) {
        CategoryEntity categoryEntity= CategoryMapper.toEntity(categoryregisterDTO);
//        var categoriaEntity= new CategoryEntity(categoryregisterDTO.id(),categoryregisterDTO.name(),categoryregisterDTO.description());
        iCategoryRepositrory.save(categoryEntity);
        return "La categoria se guardo en la base de datos";
    }

    @Override
    public CategoryDTO getReferenceById(Long id) {
        var category= CategoryMapper.toDTO(iCategoryRepositrory.getReferenceById(id));
        return category;
    }
}
