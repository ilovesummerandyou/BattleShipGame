package com.chen.jade.battleship;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Play {
	
	static int counter;

	static Map<String, String> attackCell() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter attack row between 0 to 9: ");
		String r = scan.next();
		int r1 = Integer.parseInt(r);
		while (r1 < 0 | r1 > 9) {
			System.out.println("Wrong input. Please reenter ship attack row between 0 to 9: ");
			r = scan.next();
		}
		

		System.out.print("Enter attack col between 0 to 9: ");
		String c = scan.next();
		int c1 = Integer.parseInt(c);
		while (c1 < 0 | c1 > 9) {
			System.out.println("Wrong input. Please reenter ship attack col between 0 to 9: ");
			c = scan.next();
		}

		Map<String, String> cellAttacked = new HashMap<>();
		cellAttacked.put("r", r);
		cellAttacked.put("c", c);
		
		counter++;
		
		return cellAttacked;
	}
	
	public static void playNow(Map<String, String> cellAttacked, String[][] b){
		int r = Integer.parseInt(cellAttacked.get("r"));
		int c = Integer.parseInt(cellAttacked.get("c"));
		
		int cS = 0;
		int cD = 0;
		int cB = 0;
		
		while(cS != 1 || cD != 2 ||cB != 3){
			if (!b[r][c].equals("Blank")) {
				String cellValue = b[r][c];
				switch(cellValue){
				case "S":cS++; break;
				case "D":cD++; break;
				case "B":cB++; break;
				default: break;
				}
				b[r][c] = "H";
				Board.printBoard(b);
				if(hasWon(cS, cD, cB)){
					break;
				}
				cellAttacked = attackCell();
				r = Integer.parseInt(cellAttacked.get("r"));
				c = Integer.parseInt(cellAttacked.get("c"));		
			}else {
				b[r][c] = "M";
				Board.printBoard(b);
				cellAttacked = attackCell();
				r = Integer.parseInt(cellAttacked.get("r"));
				c = Integer.parseInt(cellAttacked.get("c"));		
			}
			
		}
		
	}
	
	static boolean hasWon(int cS, int cD, int cB){
		if (cS == 1 && cD == 2 && cB ==3){
			System.out.println("you won");
			return true;
		}
		return false;
	}
	
	

}
