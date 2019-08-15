package br.com.repository.Products;

import br.com.enums.ProductType;
import br.com.repository.Product;

import java.sql.SQLException;
import java.util.Date;

public class DrinkProduct extends Product {

    private static final ProductType PRODUCT_TYPE = ProductType.DRINK;

    public DrinkProduct(String name, Double unitPrice, Integer stockQuantity, Date dhCreated, Date dhValid, String desc) throws SQLException {
        super(name, unitPrice, stockQuantity, dhCreated, dhValid, desc, PRODUCT_TYPE);
    }
}
