package com.emazon.api.stock.domain.usecase;

import com.emazon.api.stock.domain.api.IBrandServicePort;
import com.emazon.api.stock.domain.model.BrandDomain;
import com.emazon.api.stock.domain.spi.IBrandPersistencePort;
import com.emazon.api.stock.domain.util.brand.Brandconstants;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandUseCase implements IBrandServicePort {

    private IBrandPersistencePort iBrandPersistencePort;

    @Override
    public String createBrand(BrandDomain brandDomain) {
        var brandMesagge=iBrandPersistencePort.saveBrand(brandDomain);
        return Brandconstants.RETURN_BRAND_CREATE;
    }
}
