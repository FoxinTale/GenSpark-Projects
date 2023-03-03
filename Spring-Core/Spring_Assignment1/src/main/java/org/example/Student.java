package org.example;

import java.util.List;

public class Student {
    private int studentID;
    private String studentName;
    private List<Phone> numbers;
    private Address address;

    public Student(int studentID, String studentName, List<Phone> numbers, Address address) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.numbers = numbers;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", numbers=" + numbers +
                ", address=" + address +
                '}';
    }
}
