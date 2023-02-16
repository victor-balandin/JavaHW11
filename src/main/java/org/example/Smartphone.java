package org.example;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price) {
        super(id, name, price);
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
