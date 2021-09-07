package com.fdmgroup;

import java.util.ArrayList;

public class Controller {

	public static Object backgroundLog;

	public ArrayList<Elevator> ElevatorList;
	
	int startingFloor; 
	
	int destinationFloow;
	
	
	
	
	public Controller(){
		this.ElevatorList = new ArrayList<Elevator>();
	}

	//Explicitly move the lift from one floor to another 
	public void GoToDestination(int from, int to) {
		startingFloor = from; 
		destinationFloow = to;
		
	}
	
	public ArrayList<Elevator> getElevator() {
		
		return ElevatorList;
		
	}
	
	

}
