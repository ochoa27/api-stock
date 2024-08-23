package com.emazon.api.stock.domain.spi;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.model.CategoryDomain;


public interface ICategoryPerssistencePort {
    String saveCategory(CategoryDomain categoryDomain);
    CategoryDomain getReferenceById(Long id);
    CategoryDTO getReferenceByName(String name);
//    Boolean getReferenceByName(String name);



}
