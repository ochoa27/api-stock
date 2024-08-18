package com.emazon.api.stock.adapters.dto.category;


import jakarta.validation.constraints.NotNull;


public record UpdateDateCategory(
                                    @NotNull
                                    Long id,
                                    String name,
                                    String description) {
}
