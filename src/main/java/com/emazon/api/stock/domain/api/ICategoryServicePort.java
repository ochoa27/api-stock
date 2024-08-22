package com.emazon.api.stock.domain.api;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.model.CategoryDomain;


public interface ICategoryServicePort {
    String  createCategory(CategoryDomain categoryDomain);
    CategoryDTO getReferenceById(Long id);
    CategoryDTO getReferenceByName(String name);
//    Boolean getReferenceByName(String name);

}
