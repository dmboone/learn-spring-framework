package com.sandbox.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sandbox.learnspringframework.game.GameRunner;
import com.sandbox.learnspringframework.game.GamingConsole;

@Configuration
@ComponentScan("com.sandbox.learnspringframework.game") // tells Spring to search for any components within a specific package
public class GamingAppLauncherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)){
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
	}
}
