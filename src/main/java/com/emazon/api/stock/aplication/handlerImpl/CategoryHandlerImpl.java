package com.emazon.api.stock.aplication.handlerImpl;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.aplication.handler.ICategoryHandler;
import com.emazon.api.stock.domain.api.ICategoryServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryHandlerImpl implements ICategoryHandler {
    private ICategoryServicePort iCategoryServicePort;

    @Override
    public String createCategory(CategoryDTO categoryregisterDTO) {
        var mensagge= iCategoryServicePort.createCategory(categoryregisterDTO);
        return mensagge;
    }

    @Override
    public CategoryDTO getReferenceById(Long id) {
        var category=iCategoryServicePort.getReferenceById(id);
        return category;
    }


}


