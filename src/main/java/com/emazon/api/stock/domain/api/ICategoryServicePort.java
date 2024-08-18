package com.emazon.api.stock.domain.api;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;

public interface ICategoryServicePort {
    String  createCategory(CategoryDTO categoryregisterDTO);
    CategoryDTO getReferenceById(Long id);
}
