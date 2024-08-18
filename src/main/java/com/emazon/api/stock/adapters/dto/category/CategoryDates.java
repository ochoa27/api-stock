package com.emazon.api.stock.adapters.dto.category;

import com.emazon.api.stock.secondadapters.entiites.CategoryEntity;

public record CategoryDates(Long id,
                            String name,
                            String description) {

    public CategoryDates(CategoryEntity category) {
        this(category.getId(), category.getName(), category.getDescription());
    }
}

