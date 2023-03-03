package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {

    @Bean
    public Address getAddress() {
        return new Address("Castro Valley", "California", "6221 Durrwood Court", "94552");
    }

    @Bean
    public CellPhone getNumber() {
        return new CellPhone("(882) 573-0334");
    }

    @Bean
    @Autowired
    public Student getStudent(List<Phone> numbers, Address location) {
        return new Student(1, "Kaylie", numbers, location);
    }
}
