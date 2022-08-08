package com.nttdata.bootcamp.product.model.document;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection="product_type")
public class ProductType {

    @Id
    private String id;
    private String code;
    private String name;
    private boolean state;

}
