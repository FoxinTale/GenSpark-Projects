package org.example;

public class Phone {
    private String number;
// Technically, for true functionality this should be a map like: "Phone type (home / parent cell / personal cell | number)"
    public Phone(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                '}';
    }
}
