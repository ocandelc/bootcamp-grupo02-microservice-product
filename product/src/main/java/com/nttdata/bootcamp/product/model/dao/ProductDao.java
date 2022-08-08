package com.nttdata.bootcamp.product.model.dao;

import com.nttdata.bootcamp.product.model.document.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProductDao extends ReactiveMongoRepository<Product, String> {

    Mono<Product> findByCode(String code);

}
