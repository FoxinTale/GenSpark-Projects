package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public class CellPhone implements Phone{
    private String number;
    // Technically, for true functionality this should be a map like: "Phone type (home / parent cell / personal cell | number)"
    public CellPhone(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cell Phone{" +
                "number='" + number + '\'' +
                '}';
    }
}
