package com.sandbox.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// What is a Record?
// Eliminates verbosity in creating Java Beans
// No need to write accessor methods, constructor, etc.
// equals, hashcode and toString automatically created
// Release in JDK 16
record Person (String name, int age, Address address) {};

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
		var person = new Person("Destiny", 22, new Address("Main Street", "Utrecht"));
		return person;
	}
	
	@Bean(name = "address2") // can create custom bean names using attributes
	public Address address() {
		var address = new Address("Baker Street", "London");
		return address;
	}
	
	@Bean(name = "address3") // can create custom bean names using attributes
	public Address address3() {
		var address = new Address("Motinagar", "Hyderabad");
		return address;
	}
	
	// Two ways to create beans with relationships to other beans
	// 1 - Method Call
	@Bean
	public Person person2MethodCall() {
		var person = new Person(name(), age(), address()); // name, age, address
		return person;
	}
	
	// 2 - Parameters
	@Bean
	public Person person3Parameters(String name, int age, Address address3) {
		var person = new Person(name, age, address3); // name, age, address
		return person;
	}
}
