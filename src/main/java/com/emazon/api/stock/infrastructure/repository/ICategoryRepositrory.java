package com.emazon.api.stock.infrastructure.repository;


import com.emazon.api.stock.infrastructure.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ICategoryRepositrory extends JpaRepository<CategoryEntity,Long> {

    CategoryEntity findByName(String name);
    Page<CategoryEntity> findAllByName(String name,Pageable pageable);

}
