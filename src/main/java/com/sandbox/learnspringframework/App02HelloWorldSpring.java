package com.sandbox.learnspringframework;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// Launch a Spring Context using a configuration file (HelloWorldConfiguration.java)
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		// Configure the things we want Spring to manage 
		// HelloWorldConfiguration - @Configuration
		// name - @Bean
		
		// Retrieving Beans managed by Spring
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("person2MethodCall"));
		System.out.println(context.getBean("person3Parameters"));
		System.out.println(context.getBean("address2"));
	
		// How to list all beans managed by Spring Framework
		Arrays.stream(context.getBeanDefinitionNames())
		.forEach(System.out::println);
		
		// What if multiple matching beans are available?
		System.out.println(context.getBean(Address.class)); // can use the type of the bean to identify as well; if multiple beans of that type make sure to designate primary
		System.out.println(context.getBean(Person.class));
		System.out.println(context.getBean("person5Qualifier"));
	}
}
