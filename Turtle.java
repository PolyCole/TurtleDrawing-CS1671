import edu.princeton.cs.introcs.StdDraw;
import java.util.Random;
public class Turtle {
/*
 * Author: Cole Polyak
 * Turtle Class
 * 25 October 2017
 * 
 * This class creates our turtle object and updates it using StdDraw.
 * 
 */
	
	//Instance variable definitions.
	private int xPosition;
	private int yPosition;
	private boolean penDown;
	private int direction;
	private int stepSize;
	
	
	//Constructor with x and y coord initialization options.
	public Turtle(int x, int y)
	{
		xPosition = x;
		yPosition = y;
		penDown = false;
		direction = 90;
		//Defaults pen color to black.
		StdDraw.setPenColor(StdDraw.BLACK);
		stepSize = 50;
		StdDraw.filledCircle(xPosition, yPosition, 10);
	}
	
	public void forward()
	{
		//Defines temporary positions in case of line drawing needed.
		int tempX = xPosition;
		int tempY = yPosition;
		
		//Increases the x and y positions according to the laws of trigonometry. 
		//This allows the Turtle to move in non-ninety degree increments.
		xPosition += stepSize * Math.cos(Math.toRadians(direction));
		yPosition += stepSize * Math.sin(Math.toRadians(direction));
		
		StdDraw.filledCircle(xPosition, yPosition, 10);
		
		//Line drawing.
		if(penDown)
		{
			StdDraw.line(tempX, tempY, xPosition, yPosition);
		}
	}
	
	//Turns the Turtle x degrees left.
	public void left(double x)
	{
		direction += x;
	}
	
	//Turns the Turtle x degrees right.
	public void right(double x)
	{
		direction -= x;
	}

	//PenUp and PenDown change the status of the line drawing.
	public void penUp()
	{
		penDown = false;
	}
	
	public void penDown()
	{
		penDown = true;
	}
	
	//Accepts string input to be fed into a switch statement.
	public void setPenColor(String color)
	{
		switch(color.trim().toLowerCase())
		{
		case "black":
			StdDraw.setPenColor(StdDraw.BLACK);
			break;
		case "red":
			StdDraw.setPenColor(StdDraw.RED);
			break;
		case "green":
			StdDraw.setPenColor(StdDraw.GREEN);
			break;
		case "yellow":
			StdDraw.setPenColor(StdDraw.YELLOW);
			break;
		case "blue":
			StdDraw.setPenColor(StdDraw.BLUE);
			break;
		case "random":
			setRandomPenColor();
			break;
		}
	}
	
	//Sets the pen color to random when passed.
	public void setRandomPenColor()
	{
		Random rng = new Random();
		StdDraw.setPenColor(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
	}
}


