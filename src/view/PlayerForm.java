package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EventListeners.AddListener;

/**
 * @author Jihun Nam 
 */
public class PlayerForm extends JPanel implements ActionListener{

	 private JLabel name;
	 private JTextField nameField;
	 private JLabel point;
	 private JTextField pointField;
	 private JButton addButton;
	 private AddListener playerlistener;
	 
		public PlayerForm()
		{
			Dimension d = getPreferredSize();
			d.width = 380;
			d.height = 300;
			setPreferredSize(d);
			setBorder(BorderFactory.createTitledBorder("Add a Player"));
 
			name = new JLabel("Player Name:");
			nameField = new JTextField(25);
		    nameField.setInputVerifier(new NameVerifier());

			point = new JLabel("Point :");
			pointField = new JTextField(25);
			pointField.setInputVerifier(new PointVerifer());
			
			addButton = new JButton("Add");
			
			this.add(name);
			this.add(nameField);
			this.add(point);
			this.add(pointField);	
			this.add(addButton);
 
			addButton.addActionListener(this);
 
			
		}
		
		public void setPlayerListener(AddListener listener)
		{
			this.playerlistener = listener;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int _id = (int) (Math.random() * 1000);
			
			if((nameInputValidator(nameField.getText()) && (pointValidator(pointField.getText()))))
			 {
				playerlistener.playerAdded(_id,nameField.getText(),pointField.getText());
			 }
		   else
			{
				JOptionPane.showMessageDialog(this,"Invalid Input Entered");
			}

			
			
		}
		
		/*
		 * 
		 *  Method for name validation. This method will also be used when the user click the "Add" button
		 * 
		 */
		
		public boolean nameInputValidator(String name)
		{
			char[] chs = name.toCharArray();
			boolean isLetters = true;

			  for(char c:chs)
			  {
				  if(!(Character.isSpaceChar(c) || (Character.isLetter(c))))
				  {
					  isLetters = false;
					  break;
				  }
			  }
			  
			  return isLetters;
		}
		
		/*
		 * 
		 *  Method for point validation.
		 * 
		 */
		
		public boolean pointValidator(String point)
		{
			try{
				Integer.parseInt(point);
				return true;
			}
			catch(NumberFormatException e)
			{
				return false;
			}
		}
		
		
		/*
		 *  Player name input validation  
		 *  Accept only letters and space eg) Jihun Nam
		 */
		
		class NameVerifier extends InputVerifier{
 
			@Override
			public boolean verify(JComponent input) {
			    
				String nameVal = ((JTextField) input).getText();
				boolean isLetter = nameInputValidator(nameVal);

			    return isLetter;
			}
			
		}
		
		/*
		 *  Point input validation  
		 *  Accept numbers
		 */
		
		class PointVerifer extends InputVerifier{
 
			@Override
			public boolean verify(JComponent input) {
				
				String nameVal = ((JTextField) input).getText();
				boolean isNumber =  pointValidator(nameVal);
				
				return isNumber;
 
			}
			
			
			
		}
		
	
}
