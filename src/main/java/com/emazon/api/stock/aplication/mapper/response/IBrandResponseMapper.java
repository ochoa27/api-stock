package com.emazon.api.stock.aplication.mapper.response;



import com.emazon.api.stock.aplication.dto.brand.BrandDTO;
import com.emazon.api.stock.domain.model.BrandDomain;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface IBrandResponseMapper {

    IBrandResponseMapper INSTANCE = Mappers.getMapper(IBrandResponseMapper.class);

    BrandDTO brandDomainToBrandDTO(BrandDomain brandDomain);

    default Page<BrandDTO> brandDomainPageToBrandDTOPage(Page<BrandDomain> brandDomainPage) {
        List<BrandDTO> dtoList = brandDomainPage.getContent()
                .stream()
                .map(this::brandDomainToBrandDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(dtoList, brandDomainPage.getPageable(), brandDomainPage.getTotalElements());
    }
}