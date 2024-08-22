package com.emazon.api.stock.infrastructure.controller;

import com.emazon.api.stock.aplication.dto.category.CategoryDTO;
import com.emazon.api.stock.aplication.handler.ICategoryHandler;
import com.emazon.api.stock.infrastructure.mapper.CategoryMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private ICategoryHandler iCategoryHandler;

    public CategoryController(ICategoryHandler iCategoryHandler) {
        this.iCategoryHandler = iCategoryHandler;
    }

    @PostMapping("/save")
    @Transactional
    public ResponseEntity createCategory(@RequestBody @Valid CategoryDTO categoryRegister){
        var category=iCategoryHandler.createCategory(categoryRegister);
        return  ResponseEntity.ok(category);
    }

//    @GetMapping("/obtCategory/{id}")
//    public ResponseEntity<CategoryDTO> performAction(@PathVariable Long id) {
//        var category=iCategoryHandler.getReferenceById(id);
//        return ResponseEntity.ok(new CategoryDTO(CategoryMapper.toEntity(category)));
//    }

//    @PutMapping
//    @Transactional
//    public ResponseEntity updateCategory(@RequestBody @Valid UpdateDateCategoryDTO date){
//        var category=repository.getReferenceById(date.id());
//        category.UpdateDateCategory(date);
//        return ResponseEntity.ok("The category is update satisfactory: " +new CategoryDatesDTO(category));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity getCategoryById(@PathVariable Long id){
//        var category=repository.getReferenceById(id);
//        return ResponseEntity.ok(new CategoryDatesDTO(category));
//    }


}
