package com.emazon.api.stock.aplication.beanconfiguration;

import com.emazon.api.stock.aplication.handler.IBrandHandler;
import com.emazon.api.stock.aplication.handler.ICategoryHandler;
import com.emazon.api.stock.aplication.handlerImpl.BrandHandlerImpl;
import com.emazon.api.stock.aplication.handlerImpl.CategoryHandlerImpl;
import com.emazon.api.stock.aplication.mapper.ICategoryMapper;
import com.emazon.api.stock.aplication.mapper.brand.IBrandMapper;
import com.emazon.api.stock.aplication.mapper.response.ICategoryResponseMapper;
import com.emazon.api.stock.domain.api.IBrandServicePort;
import com.emazon.api.stock.domain.api.ICategoryServicePort;
import com.emazon.api.stock.domain.spi.IBrandPersistencePort;
import com.emazon.api.stock.domain.spi.ICategoryPerssistencePort;
import com.emazon.api.stock.domain.usecase.CreateBrandUseCase;
import com.emazon.api.stock.domain.usecase.CreateCategoryUseCase;
import com.emazon.api.stock.infrastructure.adapter.BrandJPAAdapter;
import com.emazon.api.stock.infrastructure.adapter.CategoryJPAAdapter;
import com.emazon.api.stock.infrastructure.repository.IBrandRepository;
import com.emazon.api.stock.infrastructure.repository.ICategoryRepositrory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {


    @Bean
    ICategoryHandler iCategoryHandler(ICategoryServicePort iCategoryServicePort, ICategoryMapper iCategoryMapper, ICategoryResponseMapper iCategoryResponseMapper){
        return new CategoryHandlerImpl( iCategoryServicePort,iCategoryMapper,iCategoryResponseMapper);
}

    @Bean
    ICategoryServicePort iCategoryServicePort( ICategoryPerssistencePort iCategoryPerssistencePort){
        return new CreateCategoryUseCase(iCategoryPerssistencePort);
    }

    @Bean
    ICategoryPerssistencePort iCategoryPerssistencePort( ICategoryRepositrory iCategoryRepositrory){
        return new CategoryJPAAdapter(iCategoryRepositrory);
    }

    @Bean
    IBrandHandler iBrandHandler(IBrandServicePort iBrandServicePort, IBrandMapper iBrandMapper){
        return new BrandHandlerImpl(iBrandServicePort,iBrandMapper);
    }

    @Bean
    IBrandServicePort iBrandServicePort(IBrandPersistencePort iBrandPersistencePort){
        return new CreateBrandUseCase(iBrandPersistencePort);
    }

    @Bean
    IBrandPersistencePort iBrandPersistencePort( IBrandRepository iBrandRepository){
        return new BrandJPAAdapter(iBrandRepository);
    }






}
