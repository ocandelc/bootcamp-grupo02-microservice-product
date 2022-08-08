package com.nttdata.bootcamp.product.model.dao;

import com.nttdata.bootcamp.product.model.document.ProductType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProductTypeDao extends ReactiveMongoRepository<ProductType, String> {

    Mono<ProductType> findByCode(String code);

}
