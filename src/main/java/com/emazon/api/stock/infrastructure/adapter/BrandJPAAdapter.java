package com.emazon.api.stock.infrastructure.adapter;

import com.emazon.api.stock.domain.spi.IBrandPersistencePort;
import com.emazon.api.stock.infrastructure.repository.IBrandRepository;

public class BrandJPAAdapter implements IBrandPersistencePort {

    private IBrandRepository iBrandRepository;
}
