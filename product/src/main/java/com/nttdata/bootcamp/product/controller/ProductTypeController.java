/**
 * Resumen.
 * Objeto                   : ProductTypeController.java
 * Descripción              : Clase de controladora para invocar a métodos CRUD con rest api.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.product.controller;

import com.nttdata.bootcamp.product.model.document.ProductType;
import com.nttdata.bootcamp.product.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/producttypes")
public class ProductTypeController {

    /** Declaración de la clase service */
    @Autowired
    private ProductTypeService productTypeService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el ProductType, tipo Mono
     */
    @PostMapping
    public Mono<ProductType> create(@RequestBody ProductType productType){
        return this.productTypeService.insert(productType);
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el ProductType, tipo Mono
     */
    @PutMapping
    public Mono<ProductType> update(@RequestBody ProductType productType){
        return this.productTypeService.update(productType);
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return this.productTypeService.delete(id);
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el ProductType, tipo String
     */
    @GetMapping("/{id}")
    public Mono<ProductType> find(@PathVariable String id) {
        return this.productTypeService.find(id);
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el ProductType, tipo String
     */
    @GetMapping("/findByCode/{code}")
    public Mono<ProductType> findByCode(@PathVariable String code) {
        return this.productTypeService.findByCode(code);
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el ProductType, tipo Flux
     */
    @GetMapping
    public Flux<ProductType> findAll() {
        return this.productTypeService.findAll();
    }

}
