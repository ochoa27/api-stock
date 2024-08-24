package com.emazon.api.stock.domain.api;

import com.emazon.api.stock.domain.model.CategoryDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryPageServicePort {

    Page<CategoryDomain> findAll(Pageable pageable);
}
