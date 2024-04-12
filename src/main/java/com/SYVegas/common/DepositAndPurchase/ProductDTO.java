package com.SYVegas.common.DepositAndPurchase;

public class ProductDTO {

    private int code;
    private String type;
    private String name;
    private int price;

    public ProductDTO() {
    }

    public ProductDTO(int code, String type, String name, int price) {
        this.code = code;
        this.type = type;
        this.name = name;
        this.price = price;
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
        return "Product{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
