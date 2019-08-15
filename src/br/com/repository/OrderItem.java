package br.com.repository;

public class OrderItem {
    private Order order;
//    private Produto produto;
    private int quantity;
    private Double unitValue;

    public OrderItem(Order order, /*Produto produto,*/ int quantity, Double unitValue) {
        this.order = order;
//        this.produto = produto;
        this.quantity = quantity;
        this.unitValue = unitValue;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

//    public Produto getProduto() {
//        return produto;
//    }
//
//    public void setProduto(Produto produto) {
//        this.produto = produto;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Double unitValue) {
        this.unitValue = unitValue;
    }
}
