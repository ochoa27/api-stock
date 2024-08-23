package com.emazon.api.stock.domain.usecase;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.api.ICategoryServicePort;

import com.emazon.api.stock.domain.model.CategoryDomain;
import com.emazon.api.stock.domain.spi.ICategoryPerssistencePort;
import com.emazon.api.stock.domain.util.DomainConstants;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryUseCase implements ICategoryServicePort {
    private ICategoryPerssistencePort iCategoryPerssistencePort;


    public Boolean verifyNameLength(CategoryDomain categoryDomain){
        if(categoryDomain.getName().length()<1 || categoryDomain.getName().length()>50){
            System.out.println(DomainConstants.RETURN_CATEGORY_CREATED_ERROR_NAME);
            return false;
        }else {
            return true;
        }
    }
    public Boolean verifyDescriptionLength(CategoryDomain categoryDomain) {
        if (categoryDomain.getDescription().length() <1  || categoryDomain.getDescription().length() > 90) {
            System.out.println(DomainConstants.RETURN_CATEGORY_CREATED_ERROR_DESCRIPTION);
            return false;
        } else {
            return true;
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
        if(categoryDomain!=null && verifyDescriptionLength(categoryDomain) && verifyNameLength(categoryDomain) && verifyDescriptionExist(categoryDomain) && verifyNameExist(categoryDomain)){
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
    public CategoryDTO getReferenceById(Long id) {
//       CategoryDTO categoryDTO=new CategoryDTO(CategoryMapper.toEntity(iCategoryPerssistencePort.getReferenceById(id)));
//        return  categoryDTO;
        return null;
    }
}
