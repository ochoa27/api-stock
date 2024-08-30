package com.emazon.api.stock.infrastructure.entities;

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


}
