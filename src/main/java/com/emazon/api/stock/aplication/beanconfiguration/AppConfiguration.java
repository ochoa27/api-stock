package com.emazon.api.stock.aplication.beanconfiguration;

import com.emazon.api.stock.aplication.handler.ICategoryHandler;
import com.emazon.api.stock.aplication.handlerImpl.CategoryHandlerImpl;
import com.emazon.api.stock.domain.api.ICategoryServicePort;
import com.emazon.api.stock.domain.spi.ICategoryPerssistencePort;
import com.emazon.api.stock.domain.usecase.CreateCategoryUseCase;
import com.emazon.api.stock.infrastructure.adapter.CategoryJPAAdapter;
import com.emazon.api.stock.infrastructure.repository.ICategoryRepositrory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {


    @Bean
    ICategoryHandler iCategoryHandler( ICategoryServicePort iCategoryServicePort){
        return new CategoryHandlerImpl( iCategoryServicePort);
}

    @Bean
    ICategoryServicePort iCategoryServicePort( ICategoryPerssistencePort iCategoryPerssistencePort){
        return new CreateCategoryUseCase(iCategoryPerssistencePort);
    }

    @Bean
    ICategoryPerssistencePort iCategoryPerssistencePort( ICategoryRepositrory iCategoryRepositrory){
        return new CategoryJPAAdapter(iCategoryRepositrory);
    }


}
