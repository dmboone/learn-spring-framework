package com.sandbox.learnspringframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass{ // Singletons by default, meaning you grab the same instance each time you refer to the bean
	
}

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Prototypes on the other hand will grab a different instance each time you refer to the bean 
@Component
class PrototypeClass{
	
}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)){
			System.out.println(context.getBean(NormalClass.class)); // normal class will print the same instance both time
			System.out.println(context.getBean(NormalClass.class));
			
			System.out.println(context.getBean(PrototypeClass.class)); // prototype class will print different instances of the bean every time
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
		}
		
	}
}
