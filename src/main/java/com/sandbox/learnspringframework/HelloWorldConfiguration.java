package com.sandbox.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// What is a Record?
// Eliminates verbosity in creating Java Beans
// No need to write accessor methods, constructor, etc.
// equals, hashcode and toString automatically created
// Release in JDK 16
record Person (String name, int age) {};

record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
	@Bean
	public String name() {
		return "Ranga";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		var person = new Person("Destiny", 22);
		return person;
	}
	
	@Bean
	public Address address() {
		var address = new Address("Baker Street", "London");
		return address;
	}
}
