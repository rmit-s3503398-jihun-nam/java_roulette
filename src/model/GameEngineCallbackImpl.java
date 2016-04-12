package model;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;

public class GameEngineCallbackImpl implements GameEngineCallback{

	 
	@Override
	public void nextNumber(int nextNumber, GameEngine engine) {
 
		System.out.println(nextNumber);
	}

	@Override
	public void result(int result, GameEngine engine) {
		// TODO Auto-generated method stub
		
	}
	
 

}
