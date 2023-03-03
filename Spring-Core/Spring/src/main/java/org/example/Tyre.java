package org.example;
// I love the way British English spells this.

public class Tyre {
    private String brand;
    private int size;
/*
    public Tyre(String brand, int size) {
        this.brand = brand;
        this.size = size;
    }

 */

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "brand='" + brand + '\'' +
                ", size=" + size +
                '}';
    }
}
