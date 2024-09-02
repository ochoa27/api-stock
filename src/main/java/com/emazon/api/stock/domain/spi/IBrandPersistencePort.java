package com.emazon.api.stock.domain.spi;

import com.emazon.api.stock.domain.model.BrandDomain;
import com.emazon.api.stock.infrastructure.entities.BrandEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandPersistencePort {
    String saveBrand(BrandDomain brandDomain);
    BrandDomain getReferenceByName(String name);
    Page<BrandDomain> getBrandList(Pageable page);
}
