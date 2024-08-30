package com.emazon.api.stock.domain.spi;

import com.emazon.api.stock.domain.model.CategoryDomain;
import org.springframework.data.domain.Pageable;


import java.util.List;


public interface ICategoryPerssistencePort {
    String saveCategory(CategoryDomain categoryDomain);
    CategoryDomain getReferenceById(Long id);
    CategoryDomain getReferenceByName(String name);
    List<CategoryDomain> getAllCategories();
    List<CategoryDomain>getAllCategoriesByName(String name, Integer page, Integer size);
    List<CategoryDomain> categoryAll(Pageable paginacion);



}
