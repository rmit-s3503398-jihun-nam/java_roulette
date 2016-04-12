package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import controller.MainController;
import controller.EventListeners.AddListener;
import controller.EventListeners.BettingListener;
import model.GameEngineCallbackImpl;
import model.GameEngineCallbackImplGUI;
import model.SimplePlayer;
import model.interfaces.GameEngine;

/**
 * @author Jihun Nam
 */
public class GameFrame extends JFrame {

	// Variables for GUI components
	
	private Toolbar toolbar;
	private PlayerForm playerForm;
	private PlayerInfoPanel playerinfo;
	private RoulettePanel r_Panel;
	private SimplePlayer newPlayer;
	
	// Variables for game logic related
	
	private final GameEngine gameEngine;
	private MainController mainController;
	private int bettingPrice;
	private int luckyNumber;
	private static int result;
 
	public GameFrame()
	{
		
	    super("Roulette Game");
	    
	    mainController = new MainController();
	    
	    gameEngine = new model.GameEngineImpl();
	    
	    gameEngine.addGameEngineCallback(new GameEngineCallbackImplGUI(this));
	    
	    this.setJMenuBar(new TopMenu().getMenu());
	    this.playerForm = new PlayerForm();
	    
	    this.toolbar = new Toolbar();
	    this.playerinfo = new PlayerInfoPanel();
	    this.r_Panel = new RoulettePanel();
	    
	    // Add toolbar on top of the mainframe
	    
	    this.add(toolbar,BorderLayout.NORTH);
	    
	    // Add new player form on left side
	    
	    this.add(playerForm,BorderLayout.WEST);
	    
	    // Add player info on right side
	    
	    this.add(playerinfo,BorderLayout.EAST);
	    
	    // show roulette at bottom
	    
	    this.add(r_Panel,BorderLayout.SOUTH);
	    
	    /*
	     *   Use interface for communication between two components 
	     */
	    
	    this.playerForm.setPlayerListener(new AddListener(){

			@Override
			public void playerAdded(int _id,String name,String point) {
 
				newPlayer = new SimplePlayer(
						Integer.toString(_id),
						name,
						Integer.parseInt(point)).getPlayer();
				
				gameEngine.addPlayer(newPlayer);
				
				/*
				 *   Show current player info next to the input form if the input is valid
				 */
				
				playerinfo.addLabelForNewPlayer(newPlayer);
				
			}
	    	
	    		
	    	
	    });
	    
	    /*
	     *   When play button clicked in toolbar, bettingPlaced will be invoked
	     */
	    
	    this.toolbar.setBettingListener(new BettingListener(){
 
			public void bettingPlaced() {
				
				if(newPlayer!=null)
				{
					/*
					 *  Bet amount and lucky number dialog
					 *  Call the methods in validationController
					 */
 
					String tmp_betting;
					do{
						tmp_betting = JOptionPane.showInputDialog(toolbar,"Betting Amount (Your points : " + newPlayer.getPoints() + ")");
					}while((bettingPrice = mainController.validationController.validateInteger(tmp_betting,newPlayer.getPoints()))==0);
					
					String tmp_luckyNumber;
					
					do{
						tmp_luckyNumber = JOptionPane.showInputDialog(toolbar,"Choose your lucky number between 1~40");
					}while((luckyNumber = mainController.validationController.validateNumberRange(tmp_luckyNumber,mainController.getWheel()))==0);

					 /*  
					  *   Number range , bet <= points validated , call the placebet 
					  */
					 
					 gameEngine.placeBet(newPlayer, luckyNumber , bettingPrice);		
					 
					 new Thread()
					 {
					        @Override
					        public void run()
					        {
					        	 result = gameEngine.spin(mainController.getWheel(), 1, 300, 60);
					        }
					 }.start();

					 playerinfo.addLabelForNewPlayer(newPlayer);
					 
				}
			}
 
	    	
	    });
	    
	    
	    
	    this.setVisible(true);
	    this.setSize(800, 600);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This exit the app when click x button
	    	    
	    
	}
	
	public RoulettePanel getRoulettePanel()
	{
		return r_Panel;
	}
	
	
	
 
}
