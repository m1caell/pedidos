package br.com.enums;

import java.io.Serializable;

public enum ProductType implements Serializable {

    FOOD(1, "Food"),
    DRINK(2, "Bebida");


    Integer id;
    String type;

    ProductType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
