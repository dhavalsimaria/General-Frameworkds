package com.dhaval.baeldung;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

	      Subject sub = (Subject) context.getBean("subject");
	      sub.beginStudy();
	    
	   }
}
