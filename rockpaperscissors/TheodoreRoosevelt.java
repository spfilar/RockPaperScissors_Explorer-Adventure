package com.rockpaperscissors;

public class TheodoreRoosevelt extends Player {

	int numMoves = 0;
	String move = null;
	
	public TheodoreRoosevelt() {
	}
	
	public TheodoreRoosevelt(int numMoves, String move) {
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

	public void setMove(String move) {
		this.move = move;
	}

	@Override
	public void move() {
		numMoves = (int)((Math.random() * 3) + 1);
		
		switch (numMoves) {
			case 1: move = "rock";
				break;
			case 2: move = "paper";
				break;
			case 3: move = "scissors";
				break;				
		}
	}

}
