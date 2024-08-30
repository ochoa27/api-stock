package com.emazon.api.stock.infrastructure.entities;


import jakarta.persistence.*;
import lombok.*;

@Table(name="brands")
@Entity(name="brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

}
