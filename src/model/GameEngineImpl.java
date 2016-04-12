package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.Timer;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
import view.GameFrame;

public class GameEngineImpl implements GameEngine{
	
	private ArrayList<Player> players = new ArrayList();
	private GameEngineCallback gameEngineCallBack;
	public GameFrame gameFrame;
 
	@Override
	public int spin(int wheelSize, int initialDelay, int finalDelay, int delayIncrement) {
		
		int num = 0;

		for(int i=initialDelay;i<finalDelay;i+=delayIncrement)
		{
			try{
				
				 Thread.sleep(i*5);
				 num = (int)(Math.random()*40)+1;
				 gameEngineCallBack.nextNumber(num,this);
			}
		  catch(Exception e)
			{
			     System.out.println(e.getStackTrace());
			}
		   
 
		}
		
		gameEngineCallBack.result(num, this);
 
		return num;
	}

	@Override
	public void addPlayer(Player player) {
 
		 this.players.add(player);
		
	}

	@Override
	public boolean removePlayer(Player player) {
	
		String id = player.getPlayerId();
		
		Iterator it = players.iterator();
		while(it.hasNext())
		{
			Player tmp = (Player) it.next();
			if(tmp.getPlayerId().equals(id))
			{
				this.players.remove(tmp);
				return true;
			}
		}		
		
		return false;
	}

	@Override
	public Player getPlayer(String id) {
	    
		Iterator it = players.iterator();
		Player pl = null;
		
		while(it.hasNext())
		{
			Player tmp = (Player) it.next();
			if(tmp.getPlayerId().equals(id))
			{
				pl = tmp;
				break;
			}
		}
		
		return pl;
		
	}

	@Override
	public boolean placeBet(Player player, int number, int bet) {
		
		return player.placeBet(number, bet);
	}

	@Override
	public void calculateResult(int result) {
	
		Iterator it = players.iterator();
		while(it.hasNext())
		{
			Player tmp = (Player) it.next();
		    int pre_points = tmp.getPoints();
			int bet = tmp.getBet();
 
			if(tmp.getNumber()==result)
			{
			   tmp.setPoints(pre_points+bet);
			}
			else
			{
			   tmp.setPoints(pre_points-bet);
			}
		}		
		
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return players;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		this.gameEngineCallBack = gameEngineCallback;
	}

	@Override
	public void removeGameEngineCallback(GameEngineCallback gameEngineCallback) {

		if(gameEngineCallback instanceof GameEngineCallback)
		{
			this.gameEngineCallBack = null;
		}
		
	} 
}
