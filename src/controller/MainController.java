/**
 * 
 */
package controller;

/**
 * @author Jihun Nam
 *
 *  
 */
public class MainController {
	
	private final int WHEEL_SIZE = 40;
	public ValidationController validationController;
	
	public MainController()
	{
		validationController = new ValidationController();
	}
	
	public int getWheel()
	{
	   return WHEEL_SIZE;
	}

		
	
}
