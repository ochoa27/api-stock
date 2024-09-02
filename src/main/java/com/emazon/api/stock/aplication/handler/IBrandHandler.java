package com.emazon.api.stock.aplication.handler;

import com.emazon.api.stock.aplication.dto.brand.BrandDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBrandHandler {
    String createBrand(BrandDTO brandDTO) ;
    Page<BrandDTO> getBrandList(Pageable page);
}
