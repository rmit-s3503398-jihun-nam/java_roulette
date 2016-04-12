/**
 * 
 */
package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.EventListeners.BettingListener;

/**
 * @author Jihun Nam
 *
 */
public class Toolbar extends JPanel implements ActionListener{

	private JButton play;
	private BettingListener betting;
	
	public Toolbar()
	{
		super();
		
		play = new JButton("Place a bet");
		this.add(play);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		play.addActionListener(this);
	}
	
	public void setBettingListener(BettingListener betting)
	{
		this.betting = betting;
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.betting.bettingPlaced();
		
	}
	
	
	
}
