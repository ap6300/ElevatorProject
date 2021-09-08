package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Elevator e;
	static List<Elevator> list = new ArrayList<Elevator>();
	static Main main = new Main();
	static int numLift = 2;
	static String only="";
	static int counter= 0;
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	    System.out.println("Please input the number of Elevator you want to create: ");
	    numLift = input.nextInt();
	    System.out.println("You selected " + numLift + " Elevator");
		
	    
	    ButtonPanel b = new ButtonPanel(main);
	    b.main();
		new ElevatorFrameView(6,0,main,numLift);
		
		for (int i = 0; i < numLift; i++){
			list.add(i, new Elevator(0, 0));
		}
	}

	public void setTextFromPanel(String s) {
		if (counter == numLift) {
			counter = 0;

		}

		thread1 t = new thread1(list.get(counter), s);
		t.setPriority(10 - counter);
		t.start();
		counter++;

	}
	
	public Elevator getElevators(int i) {
		return list.get(i);
	}
}
