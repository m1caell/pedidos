package br.com.repository;

import java.time.LocalDate;

public class Order {
    private Client client;
    private Address address;
    private Double orderValue;
    private LocalDate date;

    public Order(Client client, Address address, Double orderValue, LocalDate date) {
        this.client = client;
        this.address = address;
        this.orderValue = orderValue;
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
