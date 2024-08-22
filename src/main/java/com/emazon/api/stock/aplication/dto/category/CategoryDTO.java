package com.emazon.api.stock.aplication.dto.category;

import com.emazon.api.stock.infrastructure.entities.CategoryEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDTO(Long id,
                          @NotBlank(message = "El nombre de la categoria es obligatorio")
                                  @Size(max = 50, message = "El tamaño maximo del nombre debe ser de 50 caracteres")
                                  String name,
                          @NotBlank
                                  @Size(max = 90,message = "El tamaño maximo de la descripocion debe ser  de 90 caracteres")
                                  String description) {

    public CategoryDTO(CategoryEntity category) {
        this(category.getId(), category.getName(), category.getDescription());
    }
}
