package com.emazon.api.stock.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandDomain {

    private Long id;
    private String name;
    private String description;


    public BrandDomain(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

    }
}
