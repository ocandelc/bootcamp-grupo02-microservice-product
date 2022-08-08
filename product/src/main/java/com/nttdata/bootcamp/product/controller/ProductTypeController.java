package com.nttdata.bootcamp.product.controller;

import com.nttdata.bootcamp.product.model.document.ProductType;
import com.nttdata.bootcamp.product.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/producttypes")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping
    public Mono<ProductType> create(@RequestBody ProductType productType){
        return this.productTypeService.insert(productType);
    }

    @PutMapping
    public Mono<ProductType> update(@RequestBody ProductType productType){
        return this.productTypeService.update(productType);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return this.productTypeService.delete(id);
    }

    @GetMapping("/{id}")
    public Mono<ProductType> find(@PathVariable String id) {
        return this.productTypeService.find(id);
    }

    @GetMapping("/findByCode/{code}")
    public Mono<ProductType> findByCode(@PathVariable String code) {
        return this.productTypeService.findByCode(code);
    }

    @GetMapping
    public Flux<ProductType> findAll() {
        return this.productTypeService.findAll();
    }

}
