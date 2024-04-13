package com.SYVegas.common.DepositAndPurchase;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private int code;
    private String type;
    private String name;
    private int price;
    private int quantity;

    public ProductDTO() {
    }

    public ProductDTO(int code, String type, String name, int price, int quantity) {
        this.code = code;
        this.type = type;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

