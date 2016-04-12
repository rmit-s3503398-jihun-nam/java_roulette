/**
 * 
 */
package view;
 
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Jihun Nam
 */
public class TopMenu {

	private JMenuBar menu;
	
	public TopMenu()
	{
		menu = new JMenuBar();
		
		JMenu play = new JMenu("Choose Player");
		
		JMenuItem option1 = new JMenuItem("Player1");
		JMenuItem option2 = new JMenuItem("Player2");
		JMenuItem option3 = new JMenuItem("Player3");
		JMenuItem option4 = new JMenuItem("Player4");
		
		play.add(option1);
		play.add(option2);
		play.add(option3);
		play.add(option4);
		
		menu.add(play);
		
	}
	
	public JMenuBar getMenu()
	{
		return menu;
	}
	
}
