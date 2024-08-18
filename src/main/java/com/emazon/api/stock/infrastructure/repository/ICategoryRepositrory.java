package com.emazon.api.stock.infrastructure.repository;

import com.emazon.api.stock.infrastructure.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepositrory extends JpaRepository<CategoryEntity,Long> {

}
