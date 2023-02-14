package com.sandbox.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sandbox.learnspringframework.game.GameRunner;
import com.sandbox.learnspringframework.game.MarioGame;
import com.sandbox.learnspringframework.game.PacManGame;
import com.sandbox.learnspringframework.game.SuperContraGame;

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
		System.out.println(context.getBean("address"));
	}
}
