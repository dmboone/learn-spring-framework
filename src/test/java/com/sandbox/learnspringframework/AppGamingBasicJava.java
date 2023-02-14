package com.sandbox.learnspringframework;

import com.sandbox.learnspringframework.game.GameRunner;
import com.sandbox.learnspringframework.game.MarioGame;
import com.sandbox.learnspringframework.game.PacManGame;
import com.sandbox.learnspringframework.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		
		var superContraGame = new SuperContraGame();
		var marioGame = new MarioGame();
		var pacGame = new PacManGame();
		var gameRunner = new GameRunner(pacGame);
		gameRunner.run();
	}
}
