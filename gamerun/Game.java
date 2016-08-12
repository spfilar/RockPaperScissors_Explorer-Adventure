package com.gamerun;

import java.util.Scanner;

import com.rockpaperscissors.*;

public class Game {
	
	public static void main(String[] args) {
		
		Game newGame = new Game();
		newGame.runGame();
	}
	
	Scanner rps = new Scanner(System.in);
	private String[] gameStory = new String[20];
	private int intro = 0;
	private int needOpponent = 1;
	private int wins = 0;
	private int losses = 0;
	private int ties = 0;
	private String userMove = null;
	private String user = null;
	private String opponent = null;
	private String oppMove = null;
	boolean dontExit = true;
	boolean dontRestart = true;
	
	public Game() {
		gameStory[intro] = "Time to play Rock, Paper, Scissors!\n"
				+ "Rules of the game:\n"
				+ "You will face an opponent of your choosing.\n"
				+ "You each get one throw: rock, paper, or scissors.\n"
				+ "rock beats scissors\n"
				+ "scissors beats paper\n"
				+ "paper beats rock\n";
		gameStory[needOpponent] = "\nToday you will be playing against a president\n"
				+ "Please choose your opponent:\n"
				+ "'G' for George Washington\n"
				+ "'A' for Abraham Lincoln\n"
				+ "'T' for Theodore Roosevelt";
	}
	
	public Game(String user, String opponent) {
		super();
		this.user = user;
		this.opponent = opponent;
	}


	public void runGame() {
		
		System.out.println(gameStory[0]);
		
		this.userName();
		
	 	System.out.println(gameStory[1]);
		
		this.oppName();
		
		System.out.println("\nYour name is: " + user
				+ "\nYour opponent is: " + opponent);
		
		while(dontExit || dontRestart) {
	
			this.userMove();
			
			this.oppMove();
			
			this.calculations();				
		}	
	}
			
	public void userName() {
		
		User userName = new User();
		userName.uName();
		user = userName.getName();
	}
	
	public void oppName() {
		
		opponent = rps.nextLine();
		switch (opponent) {
		case "G": opponent = "George Washington";
			break;
		case "A": opponent = "Abraham Lincoln";
			break;
		case "T": opponent = "Theodore Roosevelt";
			break;
		default: System.out.println("Invalid entry. Please re-enter opponent choice.");
			return;
		}
	}
	
	public void userMove() {
		
		User uMove = new User();
		uMove.move();
		userMove = uMove.getUserMove();
	}
	
	public void oppMove() {
		
		switch (opponent) {
		case "George Washington": GeorgeWashington george = new GeorgeWashington();
			george.move();
			oppMove = george.getMove();
			break;
		case "Abraham Lincoln": AbrahamLincoln abe = new AbrahamLincoln();
			abe.move();
			oppMove = abe.getMove();
			break;
		case "Theodore Roosevelt": TheodoreRoosevelt teddy = new TheodoreRoosevelt();
			teddy.move();
			oppMove = teddy.getMove();
			break;
		}
	}
	
	public void calculations() {
		
		if (userMove.equals(oppMove)) {
			ties++;
			System.out.println("You tie!");
			
		} else if ((userMove.equalsIgnoreCase("rock") && oppMove.equalsIgnoreCase("scissors")) ||
				(userMove.equalsIgnoreCase("scissors") && oppMove.equalsIgnoreCase("paper")) ||
				(userMove.equalsIgnoreCase("paper") && oppMove.equalsIgnoreCase("rock"))) {
			wins++;
			System.out.println("You win!");
			
		} else if ((userMove.equalsIgnoreCase("paper") && oppMove.equalsIgnoreCase("scissors")) ||
				(userMove.equalsIgnoreCase("rock") && oppMove.equalsIgnoreCase("paper")) ||
				(userMove.equalsIgnoreCase("scissors") && oppMove.equalsIgnoreCase("rock"))) {
			losses++;
			System.out.println("You lost!");
	
		}
		System.out.println("\n" + user + "'s move is " + userMove);
		System.out.println(opponent + "'s move is " + oppMove);
		System.out.println("\nGame totals:\nwins: " + wins + "\nlosses: " + losses + "\nties: " + ties);
		
	}
}
