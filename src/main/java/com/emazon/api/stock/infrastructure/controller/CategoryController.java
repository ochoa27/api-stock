package com.emazon.api.stock.infrastructure.controller;

import com.emazon.api.stock.aplication.dto.category.CategoryDates;
import com.emazon.api.stock.aplication.dto.category.Categoryregister;
import com.emazon.api.stock.aplication.dto.category.UpdateDateCategory;
import com.emazon.api.stock.infrastructure.entities.CategoryEntity;
import com.emazon.api.stock.infrastructure.repository.ICategoryRepositrory;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryRepositrory repository;

    @PostMapping
    @Transactional
    public ResponseEntity createCategory(@RequestBody @Valid Categoryregister categoryRegister){
        var category=new CategoryEntity(categoryRegister);
        repository.save(category);
        return  ResponseEntity.ok(category);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateCategory(@RequestBody @Valid UpdateDateCategory date){
        var category=repository.getReferenceById(date.id());
        category.UpdateDateCategory(date);
        return ResponseEntity.ok("The category is update satisfactory: " +new CategoryDates(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategoryById(@PathVariable Long id){
        var category=repository.getReferenceById(id);
        return ResponseEntity.ok(new CategoryDates(category));
    }


}
