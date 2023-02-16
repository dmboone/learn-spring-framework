package com.sandbox.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named // this is the Jakarta CDI equivalent of @Component
class BusinessService{
	private DataService dataService;
	
//	@Autowired
	@Inject // this is the Jakarta CDI equivalent of @Autowired
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}

	public DataService getDataService() {
		return dataService;
	}
}

//@Component
@Named // this is the Jakarta CDI equivalent of @Component
class DataService{
	
}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessService.class).getDataService());
		}
		
	}
}
