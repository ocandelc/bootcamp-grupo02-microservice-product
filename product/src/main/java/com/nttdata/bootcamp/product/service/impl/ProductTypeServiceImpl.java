package com.nttdata.bootcamp.product.service.impl;

import com.nttdata.bootcamp.product.model.dao.ProductTypeDao;
import com.nttdata.bootcamp.product.model.document.ProductType;
import com.nttdata.bootcamp.product.service.ProductTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private static final Logger log = LoggerFactory.getLogger(ProductTypeServiceImpl.class);

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    public Mono<ProductType> insert(ProductType productType) {
        return productTypeDao.save(productType)
                .doFirst(() -> log.info("Begin Insert ProductType"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Insert ProductType"));
    }

    @Override
    public Mono<ProductType> update(ProductType productType) {
        return productTypeDao.findById(productType.getId())
                .doFirst(() -> log.info("Begin Update ProductType"))
                .map(p -> productType)
                .flatMap(this.productTypeDao::save)
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Update ProductType"));
    }

    @Override
    public Mono<Void> delete(String id) {
        return productTypeDao.deleteById(id)
                .doFirst(() -> log.info("Begin Delete ProductType"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Delete ProductType"));
    }

    @Override
    public Mono<ProductType> find(String id) {
        return productTypeDao.findById(id)
                .doFirst(() -> log.info("Begin Find ProductType"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Find ProductType"));
    }

    @Override
    public Mono<ProductType> findByCode(String code) {
        return productTypeDao.findByCode(code)
                .doFirst(() -> log.info("Begin FindByCode ProductType"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish FindByCode ProductType"));
    }

    @Override
    public Flux<ProductType> findAll() {
        return productTypeDao.findAll()
                .doFirst(() -> log.info("Begin FindAll ProductType"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish FindAll ProductType"));
    }

}
