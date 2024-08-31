package com.emazon.api.stock.categorytest;

import com.emazon.api.stock.domain.model.CategoryDomain;
import com.emazon.api.stock.domain.usecase.CreateCategoryUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DomainTest {

    @Test
    public void testRegisterCategory(){
        CategoryDomain categoryDomain=new CategoryDomain(20L,"refrigerados","productos refrigerados");
        CreateCategoryUseCase categoryUseCase =new CreateCategoryUseCase();
        final Boolean verifyNameLength=categoryUseCase.verifyCategoryName(categoryDomain);
        final Boolean verifyDescriptionLength=categoryUseCase.verifyCateryDescription(categoryDomain);
        Assertions.assertTrue(verifyNameLength);
        Assertions.assertFalse(!verifyNameLength);
        Assertions.assertTrue(verifyDescriptionLength);
        Assertions.assertFalse(!verifyDescriptionLength);
    }

    @Test
    public void testRegisterCategory1(){
        CategoryDomain categoryDomain=new CategoryDomain(21L,"refrigeradosssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss",
                "");
        CreateCategoryUseCase categoryUseCase =new CreateCategoryUseCase();
        final Boolean verifyNameLength=categoryUseCase.verifyCategoryName(categoryDomain);
        final Boolean verifyDescriptionLength=categoryUseCase.verifyCateryDescription(categoryDomain);
        Assertions.assertTrue(!verifyNameLength);
        Assertions.assertFalse(verifyNameLength);
        Assertions.assertTrue(!verifyDescriptionLength);
        Assertions.assertFalse(verifyDescriptionLength);
    }

}
