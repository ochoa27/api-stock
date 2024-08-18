package com.emazon.api.stock.domain.spi;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;

public interface ICategoryPerssistencePort {
    String saveCategory(CategoryDTO categoryregisterDTO);
    CategoryDTO getReferenceById(Long id);

}
