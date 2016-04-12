/**
 * 
 */
package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Jihun Nam
 */
public class RoulettePanel extends JPanel {

	private JLabel result;
	
	public RoulettePanel()
	{
		result = new JLabel();
		Dimension d = getPreferredSize();
		d.width = 300;
		d.height = 300;
		setPreferredSize(d);
		setBorder(BorderFactory.createTitledBorder("Roulette"));
 
		add(result);
	}
	
	
	public void showResult(int number)
	{
 
		this.result.setText("<html><span style='font-size:40px'>" + Integer.toString(number) + "</span></html>");
		this.validate();
		this.repaint();
 
	}
 
	public void showResult(String string) {
 
		this.result.setText("<html><span style='font-size:25px;'>" + string + "</span></html>");
		this.validate();
		this.repaint();
		
	}
}
