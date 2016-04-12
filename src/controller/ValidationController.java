/**
 * 
 */
package controller;

/**
 * @author Jihun Nam
 */
public class ValidationController {

	public int validateNumberRange(String string,int range)
	{
		int luckyNumber = 0;
 
		try{

			luckyNumber = Integer.parseInt(string);
 
		}
	   catch(Exception e)
		{
			return 0;
		}
		
		if((luckyNumber >= 1) && (luckyNumber <= range))
		{
			return luckyNumber;
		}
		else
		{
			return 0;
		}
		
		
	}
 
	public int validateInteger(String string,int playerPoints)
	{
		
		int bettingPrice = 0;
		
		try{

			bettingPrice = Integer.parseInt(string);

		}catch(Exception e)
		{
			return 0;
		}
		
		if(playerPoints>=bettingPrice)
		{
			return bettingPrice;
		}
		else
		{
			return 0;
		}
	}
	
}
