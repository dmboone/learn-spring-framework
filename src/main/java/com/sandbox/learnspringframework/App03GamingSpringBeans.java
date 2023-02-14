package com.sandbox.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sandbox.learnspringframework.game.GameRunner;
import com.sandbox.learnspringframework.game.GamingConsole;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
	}
}
