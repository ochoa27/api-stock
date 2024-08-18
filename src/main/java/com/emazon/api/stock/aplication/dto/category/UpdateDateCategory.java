package com.emazon.api.stock.aplication.dto.category;


import jakarta.validation.constraints.NotNull;


public record UpdateDateCategory(
                                    @NotNull
                                    Long id,
                                    String name,
                                    String description) {
}
