package model;

import java.util.Collection;
import java.util.Iterator;

import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
import view.GameFrame;
 

public class GameEngineCallbackImplGUI implements GameEngineCallback{

	private GameFrame gameFrame;
 
	public GameEngineCallbackImplGUI(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	@Override
	public void nextNumber(int nextNumber, GameEngine engine) {
 
		SwingUtilities.invokeLater(new Runnable()
		{
		       @Override
		       public void run()
		       {
		    	   gameFrame.getRoulettePanel().showResult(nextNumber);	
		       }
		});
		
		
		
	}

	@Override
	public void result(int result, GameEngine engine) {
		
		SwingUtilities.invokeLater(new Runnable()
		{
		       @Override
		       public void run()
		       {
			   		engine.calculateResult(result);
					gameFrame.getRoulettePanel().showResult("Winning Number: " + result);	
		       }
		});		
		

		
	}
	
 

}
