/**
 * 
 */
package view;

import javax.swing.SwingUtilities;

/**
 * @author Jihun Nam
 *
 */
public class ClientGUI {
 
	public static void main(String[] args) {
	   
		SwingUtilities.invokeLater(new Runnable(){
 
			public void run() {
			 
			   new GameFrame();		
				
			}
						
			
		});
		

	}

}
