package com.emazon.api.stock.secondadapters.repository;

import com.emazon.api.stock.secondadapters.entiites.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepositrory extends JpaRepository<CategoryEntity,Long> {

}
