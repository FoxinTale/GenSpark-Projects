package org.example;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;


@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper {
    @Before("execution(public void show())") // We want the execution to happen before this function in the Alien class.
    public void securityCheckStart(){
        System.out.println("Security and sanity checks begun.");
    }

    @After("execution(public void show())") // We want the execution to happen *after* this function in the Alien class.
    public void securityCheckEnd(){
        System.out.println("Security and sanity checks completed.");
    }

    @Before("execution(public void show())") // We want the execution to happen before this function in the Alien class.
    public void logBegins(){
        System.out.println("The log has started.");
    }

    @After("execution(public void show())") // We want the execution to happen *after* this function in the Alien class.
    public void logEnds(){
        System.out.println("The log has ended.");
    }
}
