package com.emazon.api.stock.infrastructure.adapter;

import com.emazon.api.stock.domain.model.CategoryDomain;
import com.emazon.api.stock.domain.spi.ICategoryPerssistencePort;
import com.emazon.api.stock.infrastructure.entities.CategoryEntity;
import com.emazon.api.stock.infrastructure.mapper.CategoryMapper;
import com.emazon.api.stock.infrastructure.repository.ICategoryRepositrory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;


@AllArgsConstructor
public class CategoryJPAAdapter implements ICategoryPerssistencePort {
    private ICategoryRepositrory iCategoryRepositrory;

    @Override
    public String saveCategory(CategoryDomain categoryDomain) {
        CategoryEntity categoryEntity= CategoryMapper.domainToEntity(categoryDomain);
        iCategoryRepositrory.save(categoryEntity);
        return "the category is save in database";
    }

    @Override
    public CategoryDomain getReferenceById(Long id) {
        var category= iCategoryRepositrory.getReferenceById(id);
        return CategoryMapper.EntitytoDomain(category);
    }

    @Override
    public CategoryDomain getReferenceByName(String name) {
        return CategoryMapper.EntitytoDomain(iCategoryRepositrory.findByName(name));
    }

    @Override
    public List<CategoryDomain> getAllCategories() {
        var listCategory=iCategoryRepositrory.findAll();
        return CategoryMapper.CategoryEntityListToCategoryDomainList(listCategory);
    }

    @Override
    public List<CategoryDomain> getAllCategoriesByName(String name, Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<CategoryEntity> products = iCategoryRepositrory.findAllByName(name, pagination).getContent();

        return CategoryMapper.CategoryEntityListToCategoryDomainList(products);
    }

    @Override
    public List<CategoryDomain> categoryAll(Pageable paginacion) {
        List<CategoryEntity> categoryEntityList=iCategoryRepositrory.findAll(paginacion).getContent();
        return CategoryMapper.CategoryEntityListToCategoryDomainList(categoryEntityList);
    }
}
