package com.emazon.api.stock.domain.api;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.model.CategoryDomain;
import org.springframework.data.domain.Pageable;


import java.util.List;


public interface ICategoryServicePort {
    String  createCategory(CategoryDomain categoryDomain);
    CategoryDomain getReferenceById(Long id);
    CategoryDTO getReferenceByName(String name);

    List<CategoryDomain> getAllCategories();

    List<CategoryDomain>getAllCategoriesByName(String name,Integer page,Integer size);
    List<CategoryDomain> getCategoryAll(Pageable paginacion);
}
