package com.fdmgroup;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.swing.JButton;


public class ElevatorFrameView {
	private final int numLift = 3;
	private final int gHeight = 10;
	int start;
	int stop;
	JFrame f;
	Controller controller = new Controller();
	public ElevatorFrameView(final int maxFloor) {
		controller.GoToDestination(2, 10);
		start = controller.startingFloor;
		stop  = controller.destinationFloow;
		//Client.backgroundLog.debug("GUI Initialised");
		f = new JFrame();

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Setting Frame width and height
		f.setSize(1080, 1050);

		// Setting the title of Frame
		f.setTitle("Big Brain -  Elevator Poject");

		// Setting the layout for the Frame
		f.getContentPane().add(new JComponent() {
			{
				final Timer timer = new Timer(1000, null);
				timer.start();
				timer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

								start = start +1;
								repaint();
								if(start==stop) {
									timer.stop();
								}

					}
				});
				
			}

			public void paintComponent(Graphics g) {
				int level = (getHeight() / (maxFloor + 1));
				
				for (int i = 0; i <= (maxFloor + 1); i++) {
					
					g.drawString(Integer.toString(i), 0, getHeight() - gHeight - level * i);
					
					g.drawLine(0, getHeight() - gHeight - level * i, f.getWidth(), getHeight() - gHeight - level * i);
				}

				g.setColor(Color.black);
				g.fillRect(0, getHeight() - gHeight, getWidth(), gHeight);

				int lWidth = 40;
				int lHeight = 50;

				int sizeModifier = numLift / 10;

				if (sizeModifier > 1) {
					lWidth = lWidth / sizeModifier;
					lHeight = lHeight / sizeModifier;
				}

//				for (int i = 0; i < numLift; i++) {
					g.setColor(Color.blue);
					g.fillRect(getWidth() / 2 / numLift + (0 * 2 * lWidth),
							(getHeight() - lHeight - gHeight) - start * level,
							lWidth, lHeight);
					g.setColor(Color.blue);
					g.fillRect(getWidth() / 2 / numLift + (1 * 2 * lWidth),
							(getHeight() - lHeight - gHeight) - start * level,
							lWidth, lHeight);
//				}

			}
		});
		

		

		/*
		 * By default frame is not visible so we are setting the visibility to true to
		 * make it visible.
		 */
		f.setVisible(true);
	}
	public static void main(String[] args) {
		ElevatorFrameView view = new ElevatorFrameView(10);
		
	}
}
