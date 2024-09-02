package com.emazon.api.stock.aplication.handler;

import com.emazon.api.stock.aplication.dto.brand.BrandDTO;
import com.emazon.api.stock.domain.exception.BrandNullPointerException;

public interface IBrandHandler {
    String createBrand(BrandDTO brandDTO) ;
}
