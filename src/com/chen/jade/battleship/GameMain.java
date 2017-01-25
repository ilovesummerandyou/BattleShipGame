package com.chen.jade.battleship;

public class GameMain {

	public static void main(String[] args) {
		String[][] b = Board.makeBoard();
		Board.printBoard(b);
		ShipDeployment.makeLayout(b);
		Play.playNow(Play.attackCell(), b);
		
	}

}
