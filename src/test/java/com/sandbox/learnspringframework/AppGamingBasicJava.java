package com.sandbox.learnspringframework;

import com.sandbox.learnspringframework.game.GameRunner;
import com.sandbox.learnspringframework.game.MarioGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		
		var marioGame = new MarioGame();
		var gameRunner = new GameRunner(marioGame);
		gameRunner.run();
	}
}
