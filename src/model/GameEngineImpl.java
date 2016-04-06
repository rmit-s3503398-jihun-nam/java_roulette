package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineImpl implements GameEngine{
	
	private ArrayList<Player> players = new ArrayList();

	@Override
	public int spin(int wheelSize, int initialDelay, int finalDelay, int delayIncrement) {
		
		int number = (int) (Math.random() * wheelSize);
		
		return number;
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
 
			if(tmp.getNumber()==result)
			{
			   int pre_points = tmp.getPoints();
			   int bet = tmp.getBet();
			   tmp.setPoints(pre_points+bet);
 
			}
		}		
		
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return players;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub
		
	} 
}
