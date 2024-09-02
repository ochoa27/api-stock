package com.emazon.api.stock.infrastructure.controller;


import com.emazon.api.stock.aplication.dto.brand.BrandDTO;
import com.emazon.api.stock.aplication.handler.IBrandHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @Operation(summary = "Brand pagination", description = "this method obtain a pagination of brands in ascend form")
    @GetMapping("/listofbrands/asc")
    public ResponseEntity<Page<BrandDTO>> getBrandListAsc (){
         final Pageable page = PageRequest.of(0,10, Sort.by(Sort.Direction.ASC,"name"));
         var brandList=iBrandHandler.getBrandList(page);
        return ResponseEntity.ok(brandList);
    }
    @Operation(summary = "Brand pagination", description = "this method obtain a pagination of brands in descend form")
    @GetMapping("/listofbrands/desc")
    public ResponseEntity<Page<BrandDTO>> getBrandListDesc (){
        final Pageable page = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC,"name"));
        var brandList=iBrandHandler.getBrandList(page);
        return ResponseEntity.ok(brandList);
    }



    }





