package br.com.repository.Products;

import br.com.enums.ProductType;
import br.com.repository.Product;

import java.sql.SQLException;
import java.util.Date;

public class FoodProduct extends Product {

    private static final ProductType PRODUCT_TYPE = ProductType.FOOD;

    public FoodProduct(String name, Double unitPrice, Integer stockQuantity, Date dhCreated, Date dhvalid, String desc) throws SQLException {
        super(name, unitPrice, stockQuantity, dhCreated, dhvalid, desc, PRODUCT_TYPE);
    }



}
