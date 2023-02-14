package com.sandbox.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass{
	// TYPES OF DEPENDENCY INJECTION
	
	 // FIELD INJECTION
	//@Autowired
	Dependency1 dependency1;
	
	//@Autowired
	Dependency2 dependency2;
	
	//**** CONSTRUCTION INJECTION - most recommended ****
	@Autowired // when doing constructor injection you don't have to write @Autowired; will be done automatically
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	// SETTER INJECTION
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2");
//		this.dependency2 = dependency2;
//	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}
}

@Component
class Dependency1{}

@Component
class Dependency2{}

@Configuration
@ComponentScan // if no package name listed here it will scan the current package
public class DepInjectionLauncherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBean(YourBusinessClass.class));
		}
		
	}
}
