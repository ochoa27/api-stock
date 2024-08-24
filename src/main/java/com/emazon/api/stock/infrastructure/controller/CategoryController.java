package com.emazon.api.stock.infrastructure.controller;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.aplication.handler.ICategoryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
@Tag(name="Category manegment", description = "operations to manage categories")
public class CategoryController {

    private ICategoryHandler iCategoryHandler;
    public CategoryController(ICategoryHandler iCategoryHandler) {
        this.iCategoryHandler = iCategoryHandler;
    }


    @Operation(summary = "Register category", description = "this method register a category in the database")
    @PostMapping("/save")
    @Transactional
    public ResponseEntity createCategory(@RequestBody @Valid CategoryDTO categoryRegister){
        var category=iCategoryHandler.createCategory(categoryRegister);
        return  ResponseEntity.ok(category);
    }

    @Operation(summary = "Get category", description = "this method register a category obtain a category that exist in the database")
    @GetMapping("/obtCategory/{id}")
    public ResponseEntity obtCategory(@PathVariable Long id) {
        var category=iCategoryHandler.getReferenceById(id);
        return ResponseEntity.ok(category);
    }

        //@PageableDefault(size = 10,sort = {"name"}) Pageable paginacion
        @GetMapping("/getallcategories")
         public ResponseEntity<Page<CategoryDTO>> categoryList(@PageableDefault(size = 10,sort = {"name"}) Pageable paginacion){
            var categoryListDto = iCategoryHandler.getAllCategories();
            Page<CategoryDTO> page= convertToPage(categoryListDto,paginacion);
//            Page<CategoryDTO> page = new PageImpl<>(categoryListDto);
//            PagedListHolder page = new PagedListHolder(categoryListDto);
//            page.setPageSize(8); // number of items per page
//            page.setPage(0);      // set to first page
            return ResponseEntity.ok(page);
    }
    public static<T> Page<T> convertToPage(List<T> objectList, Pageable pageable){
        int start = (int) pageable.getOffset();
        int end = Math.min(start+pageable.getPageSize(),objectList.size());
        List<T> subList = start>=end?new ArrayList<>():objectList.subList(start,end);
        return new PageImpl<>(subList,pageable,objectList.size());
    }





}
