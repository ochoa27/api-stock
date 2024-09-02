package com.emazon.api.stock.infrastructure.repository;

import com.emazon.api.stock.infrastructure.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<BrandEntity,Long> {
    BrandEntity findByName(String name);
}
