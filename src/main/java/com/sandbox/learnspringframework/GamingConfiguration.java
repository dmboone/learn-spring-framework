package com.sandbox.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sandbox.learnspringframework.game.GameRunner;
import com.sandbox.learnspringframework.game.GamingConsole;
import com.sandbox.learnspringframework.game.MarioGame;
import com.sandbox.learnspringframework.game.PacManGame;
import com.sandbox.learnspringframework.game.SuperContraGame;

@Configuration
public class GamingConfiguration {
			
	@Bean
	public GamingConsole game() {
		var game = new PacManGame();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
}
