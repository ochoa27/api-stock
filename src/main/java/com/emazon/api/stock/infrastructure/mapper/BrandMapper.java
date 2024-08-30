package com.emazon.api.stock.infrastructure.mapper;

import com.emazon.api.stock.domain.model.BrandDomain;
import com.emazon.api.stock.domain.model.CategoryDomain;
import com.emazon.api.stock.infrastructure.entities.BrandEntity;
import com.emazon.api.stock.infrastructure.entities.CategoryEntity;

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

    public static BrandDomain entitytoDomain(BrandEntity brandEntity) {
        if (brandEntity == null) {
            return null;
        }
        BrandDomain brandDomain = new BrandDomain(brandEntity.getId(), brandEntity.getName(), brandEntity.getDescription());
        return brandDomain;
    }

}
