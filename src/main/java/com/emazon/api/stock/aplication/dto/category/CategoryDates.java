package com.emazon.api.stock.aplication.dto.category;

import com.emazon.api.stock.infrastructure.entities.CategoryEntity;

public record CategoryDates(Long id,
                            String name,
                            String description) {

    public CategoryDates(CategoryEntity category) {
        this(category.getId(), category.getName(), category.getDescription());
    }
}

