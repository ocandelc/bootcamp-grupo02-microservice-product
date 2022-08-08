package com.nttdata.bootcamp.product.model.document;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection="product")
public class Product {

    @Id
    private String id;
    private String code;
    private String name;
    private String description;
    private String codeProductType;
    private boolean movementControl;
    private int movementCountMax;
    private double monthlyCommission;
    private boolean state;

}
