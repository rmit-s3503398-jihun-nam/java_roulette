package model;

import model.interfaces.Player;

public class SimplePlayer implements Player{
 
	private String playerName;
	private String playerId;
	private int points;
	private int bet;
	private int luckyNumber;
	
	public SimplePlayer(String playerId,String playerName,int points)
	{
		setPlayerName(playerName);
		setPlayerId(playerId);
		setPoints(points);
	}
 
	@Override
	public String getPlayerName() {
		
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName; 
		
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int points) {
	   this.points = points;
		
	}
	
	public void setPlayerId(String id)
	{
		this.playerId = id;
	}

	@Override
	public String getPlayerId() {
		return playerId;
	}

	@Override
	public boolean placeBet(int number, int bet) {
	
		if(points>=bet)
		{
			this.luckyNumber = number;
			this.bet = bet;
			return true;
		}
		
		return false;
	
	}

	@Override
	public int getBet() {
		return bet;
	}

	@Override
	public void resetBet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumber() {
	   return this.luckyNumber;
	}
	
	public String toString()
	{
		return "Player Id: "+ this.playerId + "\n" 
			 + "Player Name: " + this.playerName + "\n"
		     + "Player Points: " + this.points + "\n"
		     + "Player Lucky Number : " + this.luckyNumber + "\n"
		     + "player Bet: " + this.bet + "\n";
	}
 
}
