package com.emazon.api.stock.brandtest;

import com.emazon.api.stock.domain.model.BrandDomain;
import com.emazon.api.stock.domain.usecase.CreateBrandUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DomainBrandTest {

    @Test
    public void testRegisterBrand(){
        BrandDomain brandDomain=new BrandDomain(20L,"northbayou","prodictos para comodidad del hogar");
        CreateBrandUseCase brandUseCase =new CreateBrandUseCase();
        final Boolean verifyNameLength=brandUseCase.verifyBrandName(brandDomain);
        final Boolean verifyDescriptionLength=brandUseCase.verifyCateryDescription(brandDomain);
//        final  Boolean verifyExistName=brandUseCase.validateBrandByName("nike");
        Assertions.assertTrue(verifyNameLength);
        Assertions.assertFalse(!verifyNameLength);
        Assertions.assertTrue(verifyDescriptionLength);
        Assertions.assertFalse(!verifyDescriptionLength);
//        Assertions.assertTrue(!verifyExistName);
    }



}
