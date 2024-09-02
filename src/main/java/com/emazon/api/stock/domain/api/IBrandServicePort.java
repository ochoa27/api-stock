package com.emazon.api.stock.domain.api;

import com.emazon.api.stock.domain.exception.BrandNullPointerException;
import com.emazon.api.stock.domain.model.BrandDomain;

public interface IBrandServicePort {
    String createBrand(BrandDomain brandDomain) ;
}
