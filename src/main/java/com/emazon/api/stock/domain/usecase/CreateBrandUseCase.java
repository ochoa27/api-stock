package com.emazon.api.stock.domain.usecase;

import com.emazon.api.stock.domain.api.IBrandServicePort;
import com.emazon.api.stock.domain.spi.IBrandPersistencePort;

public class CreateBrandUseCase implements IBrandServicePort {

    private IBrandPersistencePort iBrandPersistencePort;
}
