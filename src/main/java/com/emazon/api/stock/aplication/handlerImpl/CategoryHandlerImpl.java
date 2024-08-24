package com.emazon.api.stock.aplication.handlerImpl;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.aplication.handler.ICategoryHandler;
import com.emazon.api.stock.aplication.mapper.ICategoryMapper;
import com.emazon.api.stock.aplication.mapper.response.ICategoryResponseMapper;
import com.emazon.api.stock.domain.api.ICategoryServicePort;

import com.emazon.api.stock.domain.model.CategoryDomain;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CategoryHandlerImpl implements ICategoryHandler {
    private ICategoryServicePort iCategoryServicePort;
    private ICategoryMapper iCategoryMapper;
    private ICategoryResponseMapper iCategoryResponseMapper;

    @Override
    public String createCategory(CategoryDTO categoryregisterDTO) {
        var mensagge= iCategoryServicePort.createCategory(iCategoryMapper.categoryDTOToCategoryDomain(categoryregisterDTO));
        return mensagge;
    }

    @Override
    public CategoryDTO getReferenceById(Long id) {
        var category=iCategoryResponseMapper.categoryDomainToCategoryDto(iCategoryServicePort.getReferenceById(id));
        return category;
    }

    @Override
    public CategoryDTO getReferenceByName(String name) {
        var category=iCategoryServicePort.getReferenceByName(name);
        return category;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        var cateriesList= iCategoryResponseMapper.categoryListDomainToCategoryListDto(iCategoryServicePort.getAllCategories());
        return cateriesList;
    }

//    @Override
//    public Page<CategoryDomain> findAll(Pageable paginacion) {
//        var categoryPage=iCategoryServicePort.findAll(paginacion);
//        return categoryPage;
//    }


}


