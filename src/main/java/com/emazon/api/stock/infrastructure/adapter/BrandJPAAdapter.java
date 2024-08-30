package com.emazon.api.stock.infrastructure.adapter;

import com.emazon.api.stock.domain.model.BrandDomain;
import com.emazon.api.stock.domain.model.CategoryDomain;
import com.emazon.api.stock.domain.spi.IBrandPersistencePort;
import com.emazon.api.stock.infrastructure.entities.BrandEntity;
import com.emazon.api.stock.infrastructure.mapper.BrandMapper;
import com.emazon.api.stock.infrastructure.repository.IBrandRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BrandJPAAdapter implements IBrandPersistencePort {

    private IBrandRepository iBrandRepository;

    @Override
    public String saveBrand(BrandDomain brandDomain) {
        BrandEntity brandEntity= BrandMapper.domainToEntity(brandDomain);
        iBrandRepository.save(brandEntity);
        return "The brand is save in database";
    }

    @Override
    public BrandDomain getReferenceByName(String name) {
        return BrandMapper.entitytoDomain(iBrandRepository.findByName(name));
    }
}
