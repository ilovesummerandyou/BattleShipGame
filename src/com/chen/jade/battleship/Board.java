package com.chen.jade.battleship;

public class Board {
	
	public static String[][] makeBoard(){
		String[][] b = new String[10][10];
		for (int i = 0; i < 10; i++){
			for (int j =0; j < 10; j++){
				b[i][j] = "Blank";//B for Blank
			}
		}
		return b;
	}
	
	public static void printBoard(String[][] b){
		System.out.printf("%-4s"," ");
		for (int i = 0; i < 10; i++){
			System.out.printf("%-4d",i);
		}
		System.out.println();
		
		for (int i = 0; i < 10; i++){
			System.out.printf("%-4d",i);
			for (int j =0; j < 10; j++){
				if (b[i][j].equals("Blank")) {
					System.out.printf("%-4s","-");
				} else{
					System.out.printf("%-4s",b[i][j]);
				}
				
			}
			System.out.println();
		}
	}

}
