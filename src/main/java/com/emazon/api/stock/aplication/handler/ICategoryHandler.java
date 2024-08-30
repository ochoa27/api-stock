package com.emazon.api.stock.aplication.handler;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryHandler  {
    String createCategory(CategoryDTO categoryDTO);
    CategoryDTO getReferenceById(Long id);
    CategoryDTO getReferenceByName(String name);
    List<CategoryDTO> getAllCategories();
    List<CategoryDTO>toProductResponseList(String name, Integer page, Integer size);
    List<CategoryDTO> getCategoryAll(Pageable paginacion);
}
