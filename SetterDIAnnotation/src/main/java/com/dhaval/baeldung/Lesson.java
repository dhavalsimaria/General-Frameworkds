package com.dhaval.baeldung;

import org.springframework.stereotype.Component;

@Component
public class Lesson {

    private String message1;

    public void setMessage1(String message1) {
        System.out.println(message1 + " from Dependency class.");
    }

    public void startLearning() {
        System.out.print("We are learning Setter DI using Annotations.");
    }
}
