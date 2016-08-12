package com.rockpaperscissors;

import java.util.Scanner;

public class User extends Player {

	public String userMove = null;
	public String name = null;
	Scanner rps = new Scanner(System.in);
	
	public User(String userMove, String name) {
		this.userMove = userMove;
		this.name = name;
	}
	
	public User() {
		
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
		System.out.println("Player, what is your name?");
		name = rps.nextLine();
	}
	
	public void move() {
		System.out.println("\nWhich move would you like to choose:\n"
				+ "rock, paper, or scissors?");
		userMove = rps.nextLine();
	}	
}