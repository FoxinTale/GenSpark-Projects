package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Spring works.");
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");

        Vehicle v = (Vehicle) context.getBean("bicycle"); // When using annotations, it must be lowercase, if it begins with a capital letter.
        v.drive();
    }
}
