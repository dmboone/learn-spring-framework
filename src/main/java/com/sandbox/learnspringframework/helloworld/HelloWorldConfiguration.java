package com.sandbox.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
	@Primary
	public Address address() {
		var address = new Address("Baker Street", "London");
		return address;
	}
	
	@Bean(name = "address3") // can create custom bean names using attributes
	@Qualifier("address3qualifier") // can also use Qualifiers to differentiate between beans of the same type
	public Address address3() {
		var address = new Address("Motinagar", "Hyderabad");
		return address;
	}
	
	// Two ways to create beans with relationships to other beans
	// 1 - Method Call
	@Bean
	public Person person2MethodCall() {
		var person = new Person(name(), age(), address()); // name, age, address2
		return person;
	}
	
	// 2 - Parameters
	@Bean
	public Person person3Parameters(String name, int age, Address address3) {
		var person = new Person(name, age, address3); // name, age, address3
		return person;
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address) { // this could create an error because there are multiple address beans; need to designate one as primary
		var person = new Person(name, age, address); // name, age, address2
		return person;
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) { // this could create an error because there are multiple address beans; need to designate one as primary
		var person = new Person(name, age, address); // name, age, address3
		return person;
	}
}
