package com.emazon.api.stock.aplication.dto.brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BrandDTO(Long id,
                       @NotBlank(message = "The brand name is obligatory")
                       @Size(max = 50, message = "the maximun size in description is 50 v")
                       String name,
                       @NotBlank
                       @Size(max = 120,message = "the maximun size in description is 120 caracters ")
                       String description) {


}
