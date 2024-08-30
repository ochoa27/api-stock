package com.emazon.api.stock.infrastructure.mapper;

import com.emazon.api.stock.domain.model.BrandDomain;
import com.emazon.api.stock.infrastructure.entities.BrandEntity;

public class BrandMapper {

    public static BrandEntity   domainToEntity(BrandDomain brandDomain) {
        if (brandDomain == null) {
            return null;
        }
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(brandDomain.getId());
        brandEntity.setName(brandDomain.getName());
        brandEntity.setDescription(brandDomain.getDescription());
        return brandEntity;
    }
}
