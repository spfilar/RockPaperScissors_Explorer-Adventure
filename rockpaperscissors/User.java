package com.rockpaperscissors;

import java.util.Scanner;

public class User extends Player {

	public String userMove = null;
	public String name = null;
	public boolean dontRestart = true;
	Scanner rps = new Scanner(System.in);
	
	public User(String userMove, String name, boolean dontRestart) {
		this.userMove = userMove;
		this.name = name;
		this.dontRestart = dontRestart;
	}
	
	public User() {
		
	}
	
	public boolean isDontRestart() {
		return dontRestart;
	}

	public void setDontRestart(boolean dontRestart) {
		this.dontRestart = dontRestart;
	}

	public String getUserMove() {
		return userMove;
	}
	
	public void setUserMove(String userMove) {
		this.userMove = userMove;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void uName() {
		System.out.println("Player, what's your name?");
		name = rps.nextLine();
	}
	
	@Override
	public void move() {
		do {
			System.out.format("Which move would you like to choose:\n"
				+ "rock, paper, scissors, lizard, or spock?\n"
				+ "(type 'r' at any time to restart)\n");
			userMove = rps.nextLine();
		} while (!Validation.validateUserMove(userMove));
	}
}