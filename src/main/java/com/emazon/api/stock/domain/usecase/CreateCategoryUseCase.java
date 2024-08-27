package com.emazon.api.stock.domain.usecase;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.api.ICategoryServicePort;

import com.emazon.api.stock.domain.exception.CategoryNullPointerException;
import com.emazon.api.stock.domain.model.CategoryDomain;
import com.emazon.api.stock.domain.spi.ICategoryPerssistencePort;
import com.emazon.api.stock.domain.util.category.DomainConstants;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryUseCase implements ICategoryServicePort {
    private ICategoryPerssistencePort iCategoryPerssistencePort;
    private static final  Integer MINIMUN_VALOR =1;
    private static final Integer MAX_VALOR_OF_DESCRIPTION =90;
    private static final Integer MAX_VALOR_OF_NAME =90;



    public Boolean verifyCategoryName(CategoryDomain categoryDomain){
        if(categoryDomain.getName()==null){
            throw new CategoryNullPointerException(DomainConstants.RETURN_CATEGORY_CREATED_ERROR_NAME_NULL);
        }else {
            if(categoryDomain.getName().length()< MINIMUN_VALOR || categoryDomain.getName().length()> MAX_VALOR_OF_NAME){
                System.out.println(DomainConstants.RETURN_CATEGORY_CREATED_ERROR_NAME);
                return false;
            }else {
                return true;
            }
        }
    }
    public Boolean verifyCateryDescription(CategoryDomain categoryDomain) {
        if (categoryDomain.getName() == null) {
            throw new CategoryNullPointerException(DomainConstants.RETURN_CATEGORY_CREATED_ERROR_DESCRIPTION_NULL);
        } else {
            if (categoryDomain.getDescription().length() < MINIMUN_VALOR || categoryDomain.getDescription().length() > MAX_VALOR_OF_DESCRIPTION) {
                System.out.println(DomainConstants.RETURN_CATEGORY_CREATED_ERROR_DESCRIPTION);
                return false;
            } else {
                return true;
            }
        }
    }


    public Boolean verifyDescriptionExist(CategoryDomain categoryDomain){
        if(categoryDomain.getDescription()==null){
            System.out.println(DomainConstants.RETURN_CATEGORY_CREATED_ERROR_DESCRIPTION_EMPTY);
            return false;
        }else {
            return true;
        }
    }

    public Boolean verifyNameExist(CategoryDomain categoryDomain){
        if(categoryDomain.getName()==null){
            System.out.println(DomainConstants.RETURN_CATEGORY_CREATED_ERROR_NAME_EMPTY);
            return false;
        }else {
            return true;
        }
    }

    @Override
    public CategoryDTO getReferenceByName(String name) {
        CategoryDTO categoryDTO = null;
//        try {
//            categoryDTO = new CategoryDTO(CategoryMapper.toEntity(iCategoryPerssistencePort.getReferenceByName(name)));
//        } catch (NullPointerException e) {
//            System.out.println(e.getMessage());
//        }
//        return categoryDTO;
        return categoryDTO;
    }

    @Override
    public List<CategoryDomain> getAllCategories() {
        return iCategoryPerssistencePort.getAllCategories();
    }

    @Override
    public List<CategoryDomain> getAllCategoriesByName(String name, Integer page, Integer size) {
        return iCategoryPerssistencePort.getAllCategoriesByName(name, page, size);
    }

    @Override
    public List<CategoryDomain> getCategoryAll(Pageable paginacion) {
        return iCategoryPerssistencePort.categoryAll(paginacion);
    }

    public Boolean validateferenceByName(String name) {
     var category=iCategoryPerssistencePort.getReferenceByName(name);
     if (category==null){
         return true;
     }else {
         return false;
     }
    }


    @Override
    public String createCategory(CategoryDomain categoryDomain) {
        if(categoryDomain!=null && verifyCateryDescription(categoryDomain) && verifyCategoryName(categoryDomain) && verifyDescriptionExist(categoryDomain) && verifyNameExist(categoryDomain)){
            if(validateferenceByName(categoryDomain.getName())){
                iCategoryPerssistencePort.saveCategory(categoryDomain);
                return DomainConstants.RETURN_CATEGORY_CREATE;
            }else{
                return DomainConstants.RETURN_CATEGORY_CREATED_ERROR_NAME_REPEATED;
            }

        }else{
            return DomainConstants.RETURN_CATEGORY_CREATED_ERROR;
        }

    }

    @Override
    public CategoryDomain getReferenceById(Long id) {
        return iCategoryPerssistencePort.getReferenceById(id);
    }


}
