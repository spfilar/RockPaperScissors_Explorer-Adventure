package com.rockpaperscissors;

public class GeorgeWashington extends Player {

	int numMoves = 0;
	String move = null;
	
	public GeorgeWashington() {
	}

	public GeorgeWashington(int numMoves, String move) {
		super();
		this.numMoves = numMoves;
		this.move = move;
	}

	public int getNumMoves() {
		return numMoves;
	}

	public void setNumMoves(int numMoves) {
		this.numMoves = numMoves;
	}

	public String getMove() {
		return move;
	}

	public void setOMove(String move) {
		this.move = move;
	}

	@Override
	public void move() {
		numMoves = (int)((Math.random() * 5) + 1);
		
		switch (numMoves) {
			case 1: move = "rock";
				break;
			case 2: move = "paper";
				break;
			case 3: move = "scissors";
				break;	
			case 4: move = "lizard";
				break;
			case 5: move = "spock";
				break;
		}	
	}

	
	
	
}