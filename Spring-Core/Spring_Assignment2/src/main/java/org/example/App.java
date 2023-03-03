package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * It's basically the first assignment,  but with components and not XML.
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Student student = context.getBean(Student.class);
        System.out.println(student);
    }
}
