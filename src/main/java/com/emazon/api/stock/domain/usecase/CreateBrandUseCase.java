package com.emazon.api.stock.domain.usecase;

import com.emazon.api.stock.domain.api.IBrandServicePort;
import com.emazon.api.stock.domain.exception.BrandNullPointerException;
import com.emazon.api.stock.domain.model.BrandDomain;
import com.emazon.api.stock.domain.spi.IBrandPersistencePort;
import com.emazon.api.stock.domain.util.brand.Brandconstants;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandUseCase implements IBrandServicePort {

    private IBrandPersistencePort iBrandPersistencePort;
    private static final  Integer MINIMUN_VALOR =1;
    private static final Integer MAX_VALOR_OF_DESCRIPTION =120;
    private static final Integer MAX_VALOR_OF_NAME =50;

    public Boolean verifyBrandName(BrandDomain brandDomain) {
        if(brandDomain.getName()==null){
            throw new BrandNullPointerException(Brandconstants.RETURN_BRAND_CREATED_ERROR_NAME_NULL);
        }else {
            if(brandDomain.getName().length()< MINIMUN_VALOR || brandDomain.getName().length()> MAX_VALOR_OF_NAME){
                System.out.println(Brandconstants.RETURN_BRAND_CREATED_ERROR_NAME);
                return false;
            }else {
                return true;
            }
        }
    }
    public Boolean verifyCateryDescription(BrandDomain brandDomain)  {
        if (brandDomain.getDescription() == null) {
            throw new BrandNullPointerException(Brandconstants.RETURN_BRAND_CREATED_ERROR_DESCRIPTION_NULL);
        } else {
            if (brandDomain.getDescription().length() < MINIMUN_VALOR || brandDomain.getDescription().length() > MAX_VALOR_OF_DESCRIPTION) {
                System.out.println(Brandconstants.RETURN_BRAND_CREATED_ERROR_DESCRIPTION);
                return false;
            } else {
                return true;
            }
        }
    }

    public Boolean validateBrandByName(String name) {
        var brand=iBrandPersistencePort.getReferenceByName(name);
        if (brand==null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String createBrand(BrandDomain brandDomain) {
        if (brandDomain!=null && verifyBrandName(brandDomain) && verifyCateryDescription(brandDomain)){
            if (validateBrandByName(brandDomain.getName())){
                iBrandPersistencePort.saveBrand(brandDomain);
                return Brandconstants.RETURN_BRAND_CREATE;
            }else {
                return Brandconstants.RETURN_ERROR_CREATED_BRAND_SAME_NAME;
            }
        }
            return Brandconstants.RETURN_ERROR_CREATED_BRAND;
    }

    @Override
    public Page<BrandDomain> getBrandList(Pageable page) {
        var brandList= iBrandPersistencePort.getBrandList(page);
        return brandList;
    }
}
