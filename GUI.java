package com.sample;

import javax.swing.*;
import java.awt.GridLayout;

class GUI{
      public static void window(String tresc_pytania, String[] odpowiedzi,
    		  				    String opcja_domyslna){
		  JFrame frame = new JFrame(tresc_pytania);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(300,500);
		  frame.setLayout(new GridLayout(10,1));
		  
		  JLabel pytanie = new JLabel(tresc_pytania);
		  frame.getContentPane().add(pytanie);
		  
		  int rows_left = 9;
		  ButtonGroup group = new ButtonGroup();
		  for (String odp : odpowiedzi) {
			  JRadioButton rButton = new JRadioButton();
			  rButton.setText(odp);
			  frame.getContentPane().add(rButton);
			  group.add(rButton);
			  rows_left--;
		  }
		  for (;rows_left>1;rows_left--) {
			  JLabel space = new JLabel("");
			  frame.getContentPane().add(space);
		  }
		  
		  JButton okButton = new JButton("OK");
		  frame.getContentPane().add(okButton);
		  frame.setVisible(true);
     }
}