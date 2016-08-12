package com.rockpaperscissors;

import com.gamerun.Game;

public class Validation {
	
	static String validMove = null;
	static String validName = null;
	
	public Validation(String validMove, String validName) {
	}
	
	public String getValidMove() {
		return validMove;
	}
	
	public String getValidName() {
		return validName;
	}

	public static boolean validateUserMove(String validMove) {
		
		switch (validMove) {
		case "rock":
		case "scissors":
		case "paper":
		case "lizard":
		case "spock":
			return true;
			
		case "r":
			Game newGame = new Game();
			newGame.runGame();
			
		default:
			System.out.println("Invalid move type");
			return false;
		}
	}
	
	public static boolean validateOppName(String validName) {
		
		switch(validName) {
		case "P":
		case "G":
		case "H":
		case "C":
		case "S":
		case "F":
		case "J":
		case "T":
		case "L":
		case "W":
			return true;
		default:
			System.out.println("Invalid opponent name");
			return false;
		}
	}
}
