package com.fdmgroup;

public class Elevator {
	
	int ElevatorId; 
	
	int currentFloor;
	
	public int getElevatorId() {
		return ElevatorId;
	}
	public void setElevatorId(int elevatorId) {
		ElevatorId = elevatorId;
	}
	public int getCurrentPosition() {
		return currentFloor;
	}
	public void setCurrentPosition(int currentPosition) {
		this.currentFloor = currentPosition;
	}
	 
}
