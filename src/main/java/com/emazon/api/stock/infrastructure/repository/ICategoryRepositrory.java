package com.emazon.api.stock.infrastructure.repository;

import com.emazon.api.stock.infrastructure.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepositrory extends JpaRepository<CategoryEntity,Long> {

    CategoryEntity findByName(String name);
}
