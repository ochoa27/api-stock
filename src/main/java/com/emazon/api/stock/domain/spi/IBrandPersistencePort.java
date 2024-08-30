package com.emazon.api.stock.domain.spi;

import com.emazon.api.stock.domain.model.BrandDomain;

public interface IBrandPersistencePort {
    String saveBrand(BrandDomain brandDomain);
}
