package com.emazon.api.stock.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class CategoryDomain {

    private Long id;
    private String name;
    private String description;

    private List<CategoryDomain> categories;

    public CategoryDomain(Long id, String name, String description) {
        this.id=id;
        this.name=name;
        this.description=description;
    }

}
