package com.emazon.api.stock.infrastructure.adapter;

import com.emazon.api.stock.domain.model.BrandDomain;
import com.emazon.api.stock.domain.spi.IBrandPersistencePort;
import com.emazon.api.stock.infrastructure.entities.BrandEntity;
import com.emazon.api.stock.infrastructure.mapper.BrandMapper;
import com.emazon.api.stock.infrastructure.repository.IBrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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



    @Override
    public Page<BrandDomain> getBrandList(Pageable page) {
        Page<BrandEntity> brandEntityPage = iBrandRepository.findAll(page);
        // Convertimos la lista de entidades a dominios
        List<BrandDomain> brandDomainList = brandEntityPage.getContent()
                .stream()
                .map(BrandMapper::entitytoDomain)
                .collect(Collectors.toList());
        // Devolvemos una nueva página con la lista de BrandDomain
        return new PageImpl<>(brandDomainList, page, brandEntityPage.getTotalElements());
    }


}
