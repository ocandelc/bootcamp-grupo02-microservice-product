package com.nttdata.bootcamp.product.controller;

import com.nttdata.bootcamp.product.model.document.Product;
import com.nttdata.bootcamp.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Mono<Product> create(@RequestBody Product product){
        return this.productService.insert(product);
    }

    @PutMapping
    public Mono<Product> update(@RequestBody Product product){
        return this.productService.update(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return this.productService.delete(id);
    }

    @GetMapping("/{id}")
    public Mono<Product> find(@PathVariable String id) {
        return this.productService.find(id);
    }

    @GetMapping("/findByCode/{code}")
    public Mono<Product> findByCode(@PathVariable String code) {
        return this.productService.findByCode(code);
    }

    @GetMapping
    public Flux<Product> findAll() {
        return this.productService.findAll();
    }

}
