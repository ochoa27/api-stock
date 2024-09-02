package com.emazon.api.stock.domain.api;


import com.emazon.api.stock.domain.model.BrandDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandServicePort {
    String createBrand(BrandDomain brandDomain) ;
    Page<BrandDomain> getBrandList(Pageable page);
}
