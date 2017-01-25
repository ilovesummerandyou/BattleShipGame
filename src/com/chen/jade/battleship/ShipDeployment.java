package com.chen.jade.battleship;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ShipDeployment {
	static String name;
	static int hRow;
	static int hCol;
	static String dir;
	static int len;
	
	static 	Scanner scan = new Scanner(System.in);
	
	//static Set<String> hCellsOccupied= new HashSet<>();
	static Set<String> cellsOccupied= new HashSet<>();
	static Set<String> nameEntered= new HashSet<>();
	
	public static Ship inputShip(String[][] b) {
		inputName();
		getLength(name);
		inputHRow();
		inputHCol();
		while(!isHeadValid()){
			System.out.println("Wrong head location. Plz re-enter:");
			inputHRow();
			inputHCol();
		}
		inputDir();

		Ship ship = new Ship(name,hRow, hCol, dir, len);
		return ship;
	}
	
    static void putShipToBoard(Ship ship, String[][] b){
    	String name = ship.getName();
    	int len = ship.getLength();
    	int hRow = ship.gethRow();
    	int hCol = ship.gethCol();
    	String dir = ship.getDirection();
    	
    	if (dir.equals("R")){
    		for (int i = 0; i < len; i++){
    			b[hRow][hCol + i]= name; 			
    		}
    	}else {
    		for (int i = 0; i < len; i++){
    			b[hRow+i][hCol]= name;
    		}
    	}
    }
    
    public static void makeLayout(String[][] b){
    	for (int i = 0; i < 3; i++){
        	Ship s = inputShip(b);
        	putShipToBoard(s,b);
        	Board.printBoard(b);
    	}   	
    }
	
	static void inputName(){
		System.out.print("Enter ship name: S for Submarine, D for Destroyer, B for Battleship: ");
		name = scan.next().toUpperCase();
		while(!"S".equals(name) && !"D".equals(name) && !"B".equals(name)){
			System.out.println("Wrong input. Plz reenter ship name: S for Submarine, D for Destroyer, B for Battleship:: ");
			name = scan.next().toUpperCase();
		}
		while(nameEntered.contains(name)){
			System.out.println("Repeat input. Please reenter ship name: S for Submarine, D for Destroyer, B for Battleship:: ");
			name = scan.next().toUpperCase();
		}
		nameEntered.add(name);
	}
	
	static void getLength(String name){
		switch(name){
		case "S": len = 1;break;
		case "D": len = 2;break;
		case "B": len = 3;break;
		default: break;
		}
		
	}
	
	static void inputHRow(){
		System.out.print("Enter ship hRow between 0 to 9: ");
		hRow = scan.nextInt();
		while (hRow < 0 | hRow > 9){
			System.out.println("Wrong input. Please reenter ship hRow between 0 to 9: ");
			hRow = scan.nextInt();
		}
	}
	
	static void inputHCol(){
		System.out.print("Enter ship hCol between 0 to 9: ");
		hCol = scan.nextInt();
		while (hCol < 0 | hCol > 9){
			System.out.println("Wrong input. Please reenter hCol between 0 to 9:: ");
			hCol = scan.nextInt();
		}
	}
	
	static boolean isHeadValid(){
		if(cellsOccupied.contains(hRow + " " + hCol)){
			return false;
		} else{
			//cellsOccupied.add(hRow + " " + hCol);
			return true;
		}
	}
	
	static void inputDir(){
		System.out.print("Enter ship direction: R for Right D for Down: ");
		dir = scan.next().toUpperCase();
		while(!"R".equals(dir) && !"D".equals(dir)){
			System.out.println("Wrong input. Please reenter: R for Right D for Down:");
			dir = scan.next().toUpperCase();
		}
		while (!isDirValidInBoard()){
			System.out.println("Wrong input. Outside board. Please reenter R for Right D for Down:: ");
			dir = scan.next().toUpperCase();
		}
		
		while(!hasNoOverlap()){
			System.out.println("Wrong input. Overlap. Please reenter R for Right D for Down:: ");
			dir = scan.next().toUpperCase();
		}
	}
	
	// check all ship cells in the board
	public static boolean isDirValidInBoard(){
		boolean isDirGood = true;
		if (dir.equals("R")){
			if(hCol + len >= 10) {
				isDirGood = false;
			} 
		} else{
			if( hRow + len >= 10){
				isDirGood = false;
			}
		}
		return isDirGood;
	}
	
	static boolean hasNoOverlap(){
		boolean noOverLap = true;
		if (dir.equals("R")){
			for (int i = 0; i < len; i++){
				if (cellsOccupied.contains(hRow + " " + (hCol + i))){
					noOverLap = false;
				} else {
					cellsOccupied.add(hRow + " " + (hCol + i));
				}
			}
		} else{
			for (int i = 0; i < len; i++){
				if (cellsOccupied.contains(hRow+i + " " + hCol)){
					noOverLap = false;
				} else {
					cellsOccupied.add(hRow+i + " " + hCol);
				}
			}
		}
		
		return noOverLap;
	}


}
