package com.dhaval.baeldung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("lesson")
public class Lesson {
	
	@Autowired
	public Lesson(String str1, String str2){
	      System.out.println(str1 + " " + str2 + " from Dependency class");
	   }
	   public void startLearning() {
	      System.out.println("We are learning Constructor DI using Annotations." );
	   }
}
