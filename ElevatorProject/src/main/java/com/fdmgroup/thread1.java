package com.fdmgroup;



public class thread1 extends Thread {

	Elevator e1;
	
	private String input;
	public thread1(Elevator e , String input) {
		this.e1 = e;
		this.input = input;
	}
	
	
	
	public void run() {
		int dest;
		int from;
		int current = e1.getCurrentFloor();
		synchronized (input) {
			String[] s = input.split(" ");
			dest = Integer.parseInt(s[3]);
			from = Integer.parseInt(s[1]);
			System.out.println(from+" "+ dest);
		}
		
		if(current!=from) {
			if(current>from) {
				current--;
				while(current>=from) {
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					e1.setCurrentFloor(current);
					current--;
				}
			}else {
				current++;
				while(current<=from) {
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					e1.setCurrentFloor(current);
					current++;
				}
			}
			
		}

		if (dest > from) {
			while (from != dest + 1) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				e1.setCurrentFloor(from);
				from++;
			}
		} else {
			while (from != dest - 1) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				e1.setCurrentFloor(from);
				from--;
			}
		}
		
		
		
	}
	
	

}
