package com.emazon.api.stock.aplication.handler;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;

public interface ICategoryHandler  {
    String createCategory(CategoryDTO categoryDTO);
    CategoryDTO getReferenceById(Long id);
    CategoryDTO getReferenceByName(String name);

}
