package com.fdmgroup;

public class Elevator {
	
	private int direction;
	private int currentFloor;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Elevator(int direction, int currentFloor) {
		this.direction = direction;
		this.currentFloor = currentFloor;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	 
}
