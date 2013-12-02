/* name: Braeden Christensen And Steele Anderson
Assignment: A10 - Team Assignment
Class - Programming 1400
*/
import java.util.Random;
import java.util.Arrays;
public class Rooms
{
	
	//attributes/fields
	private String cardinalDirection;
	private Critters critter;
	
	//constructors
	public Rooms(String direction, Critters critterLivingHere)
	{
		//Set the room direction, and what critter lives there.
		cardinalDirection = direction;
		critter = critterLivingHere;
	}
	
	//methods
	
	public String getDirection()
	{
		return cardinalDirection;
	}
	
	public Critters getCritter()
	{
		return critter;
	}



}
