package com.sandbox.learnspringframework;

import com.sandbox.learnspringframework.game.GameRunner;
import com.sandbox.learnspringframework.game.MarioGame;
import com.sandbox.learnspringframework.game.PacManGame;
import com.sandbox.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
		// Object creation
		var superContraGame = new SuperContraGame();
		var marioGame = new MarioGame();
		var pacGame = new PacManGame();
		
		// Wiring dependencies (game is a dependency of GameRunner)
		var gameRunner = new GameRunner(pacGame);
		gameRunner.run();
	}
}
