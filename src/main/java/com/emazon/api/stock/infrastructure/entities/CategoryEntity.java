package com.emazon.api.stock.infrastructure.entities;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name="category")
@Entity(name="Category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public CategoryEntity(CategoryDTO category){
        this.name= category.name();
        this.description= category.description();
    }

    public void UpdateDateCategory(CategoryDTO date) {
        if (date.name()!=null){
            this.name= date.name();
        }
        if (date.description()!=null){
            this.description= date.description();
        }
    }
}
