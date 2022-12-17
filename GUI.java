package com.sample;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

public class GUI{
	
	public static String answer;
	
	private static String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
      public static String window(String tresc_pytania, String[] odpowiedzi){
    	  answer = null;
		  JFrame frame = new JFrame(tresc_pytania);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(300,500);
		  frame.setLayout(new GridLayout(10,1));
		  
		  JLabel pytanie = new JLabel(tresc_pytania);
		  frame.getContentPane().add(pytanie);
		  
		  ButtonGroup group = new ButtonGroup();
		  int rows_left = 9;
		  if (odpowiedzi == null) {
			  JLabel fin = new JLabel("is a right game genre for you");
			  frame.getContentPane().add(fin);
			  answer = tresc_pytania;
			  rows_left--;
		  }
		  else {
			  for (String odp : odpowiedzi) {
				  JRadioButton rButton = new JRadioButton();
				  rButton.setText(odp);
				  frame.getContentPane().add(rButton);
				  group.add(rButton);
				  rows_left--;
			  }
		  }
		  for (;rows_left>1;rows_left--) {
			  JLabel space = new JLabel("");
			  frame.getContentPane().add(space);
		  }
		  
		  
		  JButton okButton = new JButton("OK");
		  frame.getContentPane().add(okButton);
		  frame.setVisible(true);
		  
		  okButton.addMouseListener(new MouseListener() {
	            @Override
	            public void mouseClicked(MouseEvent mouseEvent) {
	            	if (odpowiedzi != null) {
	            		answer = getSelectedButtonText(group);
	            	}
	            	
	                //System.out.println( answer );
	            	if(answer != null) {
	            		frame.dispose();
	            	}
	            }

	            @Override
	            public void mousePressed(MouseEvent mouseEvent) {}
	            @Override
	            public void mouseReleased(MouseEvent mouseEvent) {}
	            @Override
	            public void mouseEntered(MouseEvent mouseEvent) {}
	            @Override
	            public void mouseExited(MouseEvent mouseEvent) {}
	      });
		  while(answer == null) { //wait until user chooses the answer and clicks ok button
			System.out.print("");
		  }
		  return answer;
     }
      
}
