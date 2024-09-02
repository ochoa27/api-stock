package com.emazon.api.stock.infrastructure.controller;


import com.emazon.api.stock.aplication.dto.brand.BrandDTO;
import com.emazon.api.stock.aplication.handler.IBrandHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
@Tag(name="Brand managment", description = "operations to manage brands")
public class BrandController {

     private IBrandHandler iBrandHandler;
     public BrandController(IBrandHandler iBrandHandler) {this.iBrandHandler = iBrandHandler;}


    @Operation(summary = "Register brand", description = "this method register a brand in the database")
    @PostMapping("/save")
    @Transactional
    public ResponseEntity createBrand(@RequestBody @Valid BrandDTO brandDTO) {
        var brand=iBrandHandler.createBrand(brandDTO);
        return  ResponseEntity.ok(brand);
    }



    }





