package com.emazon.api.stock.domain.spi;

import com.emazon.api.stock.domain.model.BrandDomain;
import com.emazon.api.stock.domain.model.CategoryDomain;

public interface IBrandPersistencePort {
    String saveBrand(BrandDomain brandDomain);
    BrandDomain getReferenceByName(String name);
}
