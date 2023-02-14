package com.sandbox.learnspringframework.game;

public class PacManGame implements GamingConsole {
	public void up() {
		System.out.println("Eat up");
	}
	
	public void down() {
		System.out.println("Eat down");
	}
	
	public void left() {
		System.out.println("Eat back");
	}
	
	public void rigt() {
		System.out.println("Eat right");
	}
}
