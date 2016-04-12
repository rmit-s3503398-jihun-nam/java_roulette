/**
 * 
 */
package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.SimplePlayer;

/**
 * @author Jihun Nam
 *
 *  
 */
public class PlayerInfoPanel extends JPanel {

	private JTextArea text;
	private JLabel playerInfo;
 
	public PlayerInfoPanel()
	{
		Dimension d = getPreferredSize();
		d.width = 400;
		d.height = 300;
		setPreferredSize(d);
		setBorder(BorderFactory.createTitledBorder("Player Info"));
 
	}
	
	public void addLabelForNewPlayer(SimplePlayer player)
	{
        this.removeAll(); // remove all components in this panel before rendering
		
		String _id = player.getPlayerId();
		String name = player.getPlayerName();
		int point = player.getPoints();
		int luckyNumber = player.getNumber();

		playerInfo = new JLabel(_id);
		playerInfo.setText("<html>Current Player<br>Player ID: " + _id + "<br>Player Name: " + name +"<br>Player Point: "+ point +"<br>Player Lucky Number:"+luckyNumber+"</html>");
 
		this.add(playerInfo);
		this.validate();
		this.repaint();
	}
	
	
	
}
