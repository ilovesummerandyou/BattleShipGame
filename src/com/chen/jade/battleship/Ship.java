package com.chen.jade.battleship;

public class Ship {
	private String name;
	private int hRow; // for the head of ship
	private int hCol;
	private String direction; // Right or Down
	private int length;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int gethRow() {
		return hRow;
	}
	public void sethRow(int hRow) {
		this.hRow = hRow;
	}
	public int gethCol() {
		return hCol;
	}
	public void sethCol(int hCol) {
		this.hCol = hCol;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Ship(String name, int hRow, int hCol, String direction, int length) {
		super();
		this.name = name;
		this.hRow = hRow;
		this.hCol = hCol;
		this.direction = direction;
		this.length = length;
	}

}
