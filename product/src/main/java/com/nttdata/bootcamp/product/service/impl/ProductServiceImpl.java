package com.nttdata.bootcamp.product.service.impl;

import com.nttdata.bootcamp.product.model.dao.ProductDao;
import com.nttdata.bootcamp.product.model.document.Product;
import com.nttdata.bootcamp.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductDao productDao;

    @Override
    public Mono<Product> insert(Product product) {
        return productDao.save(product)
                .doFirst(() -> log.info("Begin Insert Product"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Insert Product"));
    }

    @Override
    public Mono<Product> update(Product product) {
        return productDao.findById(product.getId())
                .doFirst(() -> log.info("Begin Update Product"))
                .map(p -> product)
                .flatMap(this.productDao::save)
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Update Product"));
    }

    @Override
    public Mono<Void> delete(String id) {
        return productDao.deleteById(id)
                .doFirst(() -> log.info("Begin Delete Product"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Delete Product"));
    }

    @Override
    public Mono<Product> find(String id) {
        return productDao.findById(id)
                .doFirst(() -> log.info("Begin Find Product"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish Find Product"));
    }

    @Override
    public Mono<Product> findByCode(String code) {
        return productDao.findByCode(code)
                .doFirst(() -> log.info("Begin FindByCode Product"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish FindByCode Product"));
    }

    @Override
    public Flux<Product> findAll() {
        return productDao.findAll()
                .doFirst(() -> log.info("Begin FindAll Product"))
                .doOnNext(p -> log.info(p.toString()))
                .doAfterTerminate(() -> log.info("Finish FindAll Product"));
    }

}
