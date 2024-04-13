package com.SYVegas.chip;

public class Chip {
    private int value; // 100, 50, 10, 5, 1
    private int quantity;

    public Chip(int value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Chip{" +
                "value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}