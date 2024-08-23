package com.emazon.api.stock.domain.api;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.model.CategoryDomain;


public interface ICategoryServicePort {
    String  createCategory(CategoryDomain categoryDomain);
    CategoryDomain getReferenceById(Long id);
    CategoryDTO getReferenceByName(String name);


}
