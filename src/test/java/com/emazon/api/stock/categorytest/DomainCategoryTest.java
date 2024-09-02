package com.emazon.api.stock.categorytest;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.domain.model.CategoryDomain;
import com.emazon.api.stock.domain.usecase.CreateCategoryUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;

@SpringBootTest
public class DomainCategoryTest {

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

    @Test
    public void testPaginationCategory(){
            Sort sort = Sort.by("name").descending();
            Pageable pageableWithSort = PageRequest.of(1,10, sort);
            CategoryDTO categoryDTO=new CategoryDTO(18L,
                "comida mexicana juanca",
                "esta es la categoria de elementos de comida mexicana juanca ");
            var categoryListDto = new ArrayList<CategoryDTO>();
            categoryListDto.add(categoryDTO);
            CreateCategoryUseCase categoryUseCase =new CreateCategoryUseCase();
            CategoryDomain categoryDomain=new CategoryDomain(18L,
                    "comida mexicana juanca",
                    "esta es la categoria de elementos de comida mexicana juanca ");
            categoryUseCase.createCategory(categoryDomain);
            var listaCategorias=  categoryUseCase.getCategoryAll(pageableWithSort);
            assert( listaCategorias.size()==1);
            assert(listaCategorias.get(0).getName()=="comida mexicana juanca");
            assert (listaCategorias.get(0).getDescription()!="comida mexicana juanca");

    }


    }
