package com.dhaval.baeldung;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("com/dhaval/baeldung/Beans.xml");

	      Subject sub = (Subject) context.getBean("subject");
	      sub.beginStudy();
	    ///ConstructorDI/src/main/resources/Beans.xml
	   }
}
