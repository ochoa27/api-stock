package com.emazon.api.stock.domain.usecase;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.api.ICategoryServicePort;
import com.emazon.api.stock.domain.spi.ICategoryPerssistencePort;
import com.emazon.api.stock.infrastructure.mapper.CategoryMapper;
import lombok.AllArgsConstructor;



@AllArgsConstructor
public class CreateCategoryUseCase implements ICategoryServicePort {
    private ICategoryPerssistencePort iCategoryPerssistencePort;

    @Override
    public String createCategory(CategoryDTO categoryregisterDTO) {
        iCategoryPerssistencePort.saveCategory(categoryregisterDTO);
        return "Categoria creada con exito";
    }

    @Override
    public CategoryDTO getReferenceById(Long id) {
       CategoryDTO categoryDTO=new CategoryDTO(CategoryMapper.toEntity(iCategoryPerssistencePort.getReferenceById(id)));
        return  categoryDTO;
    }

}
