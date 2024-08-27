package com.emazon.api.stock.domain.spi;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.model.CategoryDomain;
import com.emazon.api.stock.infrastructure.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


public interface ICategoryPerssistencePort {
    String saveCategory(CategoryDomain categoryDomain);
    CategoryDomain getReferenceById(Long id);
    CategoryDTO getReferenceByName(String name);
    List<CategoryDomain> getAllCategories();
    List<CategoryDomain>getAllCategoriesByName(String name, Integer page, Integer size);
    List<CategoryDomain> categoryAll(Pageable paginacion);
//    Boolean getReferenceByName(String name);



}
