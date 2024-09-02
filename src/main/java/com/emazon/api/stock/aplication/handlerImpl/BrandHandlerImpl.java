package com.emazon.api.stock.aplication.handlerImpl;

import com.emazon.api.stock.aplication.dto.brand.BrandDTO;
import com.emazon.api.stock.aplication.handler.IBrandHandler;
import com.emazon.api.stock.aplication.mapper.brand.IBrandMapper;
import com.emazon.api.stock.aplication.mapper.response.IBrandResponseMapper;
import com.emazon.api.stock.domain.api.IBrandServicePort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class BrandHandlerImpl implements IBrandHandler {
    private IBrandServicePort iBrandServicePort;
    private IBrandMapper iBrandMapper;
    private IBrandResponseMapper iBrandResponseMapper;

    @Override
    public String createBrand(BrandDTO brandDTO) {
        var brand=iBrandServicePort.createBrand(iBrandMapper.categoryDTOToCategoryDomain(brandDTO));
        return  brand;
    }

    @Override
    public Page<BrandDTO> getBrandList(Pageable page) {
        var brandList=iBrandServicePort.getBrandList(page);
        Page<BrandDTO> brandListMapeado=iBrandResponseMapper.brandDomainPageToBrandDTOPage(brandList);
        return brandListMapeado;
    }
}
