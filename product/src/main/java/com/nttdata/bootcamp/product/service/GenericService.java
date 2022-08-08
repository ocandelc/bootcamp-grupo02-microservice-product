package com.nttdata.bootcamp.product.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;

public interface GenericService <T, Id extends Serializable> {

    Mono<T> insert(T t);

    Mono<T> update(T t);

    Mono<Void> delete(Id id);

    Mono<T> find(Id id);

    Mono<T> findByCode(String code);

    Flux<T> findAll();

}