package com.gamerun;

import java.util.Scanner;

import com.rockpaperscissors.*;

public class Game {
	
	Scanner rps = new Scanner(System.in);
	private int wins = 0;
	private int losses = 0;
	private int ties = 0;
	private String intro = null;
	private String needOpponent = null;
	private String userMove = null;
	private String user = null;
	private String opponent = null;
	private String oppMove = null;
	private boolean dontRestart = true;
	
	public static void main(String[] args) {
		
		Game newGame = new Game();
		newGame.runGame();
	}

	public void runGame() {
		
		System.out.println(intro);
		this.userName();

		this.oppName();
		
		System.out.println("\nYour name is: " + user
				+ "\nYour opponent is: " + opponent);
		
		while(dontRestart) {
			
			this.userMove();
			
			if (dontRestart) {
				this.oppMove();
				this.calculations();
				
			} else { runGame(); }
		}	
	}
			
	public void userName() {
		
		User userName = new User();
		userName.uName();
		user = userName.getName();
	}
	
	public void oppName() {
		
		do {
			System.out.println(needOpponent);
			opponent = rps.nextLine();
			
		} while (!(Validation.validateOppName(opponent)));
		
		switch (opponent) {
		case "W": opponent = "George Washington";
			break;
		case "L": opponent = "Abraham Lincoln";
			break;
		case "T": opponent = "Theodore Roosevelt";
			break;
		case "J": opponent = "Andrew Jackson";
			break;
		case "F": opponent = "Frankling Roosevelt";
			break;
		case "S": opponent = "George H. W. Bush";
			break;
		case "C": opponent = "Grover Cleveland";
			break;
		case "H": opponent = "Herbert Hoover";
			break;
		case "G": opponent = "James Garfield";
			break;
		case "P": opponent = "Thomas Jefferson";
			break;
		}
	}
	
	public void userMove() {
		
		User uMove = new User();
		uMove.move();
		userMove = uMove.getUserMove();
		dontRestart = uMove.isDontRestart();	
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
		case "Andrew Jackon": AndrewJackson drew = new AndrewJackson();
			drew.move();
			oppMove = drew.getMove();
			break;
		case "Franklin Roosevelt": FranklinRoosevelt fdr = new FranklinRoosevelt();
			fdr.move();
			oppMove = fdr.getMove();
			break;
		case "George H. W. Bush": GeorgeBushSr sr = new GeorgeBushSr();
			sr.move();
			oppMove = sr.getMove();
			break;
		case "Grover Cleveland": GroverCleveland grove = new GroverCleveland();
			grove.move();
			oppMove = grove.getMove();
			break;
		case "Herbert Hoover": HerbertHoover herb = new HerbertHoover();
			herb.move();
			oppMove = herb.getMove();
			break;
		case "James Garfield": JamesGarfield jim = new JamesGarfield();
			jim.move();
			oppMove = jim.getMove();
			break;
		case "Thomas Jefferson": ThomasJefferson tom = new ThomasJefferson();
			tom.move();
			oppMove = tom.getMove();
			break;
		}
	}
	
	public void calculations() {
		
		if (userMove.equals(oppMove)) {
			ties++;
			System.out.println("\nYou tie!");
			
		} else if ((userMove.equalsIgnoreCase("rock") && (oppMove.equalsIgnoreCase("scissors") || oppMove.equalsIgnoreCase("lizard"))) ||
				(userMove.equalsIgnoreCase("scissors") && (oppMove.equalsIgnoreCase("paper") || oppMove.equalsIgnoreCase("lizard"))) ||
				(userMove.equalsIgnoreCase("paper") && (oppMove.equalsIgnoreCase("rock") || oppMove.equalsIgnoreCase("spock"))) ||
				(userMove.equalsIgnoreCase("lizard") && (oppMove.equalsIgnoreCase("spock") || oppMove.equalsIgnoreCase("paper"))) ||
				(userMove.equalsIgnoreCase("spock") && (oppMove.equalsIgnoreCase("scissors") || oppMove.equalsIgnoreCase("rock")))) {
			wins++;
			System.out.println("\nYou win!");
			
		} else if ((oppMove.equalsIgnoreCase("rock") && (userMove.equalsIgnoreCase("scissors") || userMove.equalsIgnoreCase("lizard"))) ||
				(oppMove.equalsIgnoreCase("scissors") && (userMove.equalsIgnoreCase("paper") || userMove.equalsIgnoreCase("lizard"))) ||
				(oppMove.equalsIgnoreCase("paper") && (userMove.equalsIgnoreCase("rock") || userMove.equalsIgnoreCase("spock"))) ||
				(oppMove.equalsIgnoreCase("lizard") && (userMove.equalsIgnoreCase("spock") || userMove.equalsIgnoreCase("paper"))) ||
				(oppMove.equalsIgnoreCase("spock") && (userMove.equalsIgnoreCase("scissors") || userMove.equalsIgnoreCase("rock")))) {
			losses++;
			System.out.println("\nYou lost!");
		}
		
		System.out.println(user + " used " + userMove);
		System.out.println(opponent + " used " + oppMove);
		System.out.println("\nGame totals:"
				+ "\nwins: " + wins + "\nlosses: " + losses + "\nties: " + ties);	
	}
	
	public Game() {
		intro = "\nTime to play Rock, Paper, Scissors, Lizard, Spock!"
				+ "\nRules of the game:"
				+ "\nYou will face an opponent of your choosing."
				+ "\nYou each get one throw: rock, paper, scissors, lizard, or spock."
				+ "\nrock: crushes scissors & crushes lizard"
				+ "\nscissors: cuts paper & decapitates lizard"
				+ "\npaper: covers rock & disproves spock"
				+ "\nlizard: eats paper & poisons spock"
				+ "\nspock: smashes scissors & vaporizes rock";
		needOpponent = "\nPlease choose your opponent:"
				+ "\n'W' for George Washington"
				+ "\n'L' for Abraham Lincoln"
				+ "\n'T' for Theodore Roosevelt"
				+ "\n'J' for Andrew Jackson"
				+ "\n'F' for Franklin Roosevelt"
				+ "\n'S' for George H. W. Bush"
				+ "\n'C' for Grover Cleveland"
				+ "\n'H' for Herbert Hoover"
				+ "\n'G' for James Garfield"
				+ "\n'P' for Thomas Jefferson";
	}
}
