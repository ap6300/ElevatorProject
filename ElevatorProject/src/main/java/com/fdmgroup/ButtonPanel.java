package com.fdmgroup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.SwingConstants;

public class ButtonPanel extends JFrame implements ActionListener {
	
	JLabel display;
	JButton numButton;
	JButton clearButton;
	String displayContent = "";
	String[] numPadContent = {"1","2","3","4","5","6","7","8","9","from","0","to"};
	ArrayList<JButton> buttonList;
	
	
	public ButtonPanel() {
		
		
		JPanel pane = new JPanel();
		pane.setPreferredSize(new Dimension(400, 400));
		
		
		display = new JLabel(displayContent);
		display.setPreferredSize(new Dimension(320, 50));
		
		display.setBorder(BorderFactory.createLoweredBevelBorder());
		
		pane.add(display, BorderLayout.NORTH);
		
		// initialize the buttonList
		buttonList = new ArrayList<JButton>(12);
		JPanel numberPanel = new JPanel();
		
		numberPanel.setLayout(new GridLayout(4,3,0,0));
		// set the size of the numberPanel
		numberPanel.setPreferredSize(new Dimension(320,260));
		
		for (int i = 0; i < numPadContent.length; i++) {
			numButton = new JButton(numPadContent[i]);
			buttonList.add(numButton);
		}
		// add the buttonList to the number panel
		for (int n = 0; n < buttonList.size(); n++) {
			buttonList.get(n).addActionListener(this);
			numberPanel.add(buttonList.get(n));
		}
		
		// create black border around the number panel
		numberPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
		// add number panel to center part of display
		pane.add(numberPanel, BorderLayout.CENTER);
		
		
		clearButton = new JButton("Clear");
		clearButton.setPreferredSize(new Dimension(320, 50));
		clearButton.addActionListener(this);
		

		
		// add Clear button to bottom of display
		pane.add(clearButton, BorderLayout.SOUTH);
		add(pane,BorderLayout.CENTER);
	}
	
	// update the display depending on clicked button(s)
	public void actionPerformed(ActionEvent e) {
		String textThere = display.getText();
		String additionalText = "";
		
		for (int a = 0; a < buttonList.size(); a++) {
			if (e.getSource().equals(buttonList.get(a))) {
				additionalText = buttonList.get(a).getText();
			}
		}
		
		
		if (e.getSource().equals(clearButton)) {
			textThere = "";
		}
		display.setText(textThere.concat(additionalText));
	}
	
	public static void main(String[] args) {
		
		//create and set up the window.
		JFrame frame = new ButtonPanel();
		frame.setTitle("Button Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500,1500);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
}