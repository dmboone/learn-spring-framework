package com.sandbox.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready!");
	}
	
	@PostConstruct // enables this function to run as soon as dependency injection (aka the constructor) is done to perform any sort of initialization
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy // runs once an instance is in the process of being removed by the container; typically used to release resources that it has been holding and any other kind of cleanup
	public void cleanup() {
		System.out.println("Cleanup");
	}
}

@Component
class SomeDependency{
	public void getReady() {
		System.out.println("Some logic using SomeDependency");
	}
	
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
		}
		
	}
}
