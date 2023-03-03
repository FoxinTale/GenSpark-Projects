package org.example;

public class HomePhone implements Phone{
    private String number;
    // Technically, for true functionality this should be a map like: "Phone type (home / parent cell / personal cell | number)"
    public HomePhone(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Home Phone{" +
                "number='" + number + '\'' +
                '}';
    }
}
