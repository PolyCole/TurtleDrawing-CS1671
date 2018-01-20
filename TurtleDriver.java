import java.util.Scanner;
import edu.princeton.cs.introcs.StdDraw;
public class TurtleDriver {
	public static final int canvas = 1000;
	public static void main(String[] args) {
		
		
		/*
		 * Author: Cole Polyak
		 * TurtleDriver Class
		 * 25 October 2017
		 * 
		 * This driver feeds commands to our created turtle object. Will infinitely loop until the user closes
		 * the StdDraw window.
		 * 
		 */
				
		//Setting up Canvas and setting default pen color.
		StdDraw.setCanvasSize(canvas, canvas);
		StdDraw.setXscale(0, canvas);
		StdDraw.setYscale(0, canvas);
		StdDraw.setPenColor(StdDraw.BLACK);
		
		//Our Turtle and Scanner initializations.
		Turtle turtle = new Turtle(canvas / 2, canvas /2);
		Scanner keyboard = new Scanner(System.in);
		
		//These variables help process the input.
		String needNumbers = "rightleftforward";
		String needsWords = "pencolor";
		String newColor = "black";
		int commandNumber = 0;
		
		while(true)
		{
			System.out.println("Please enter a command");
			
			//First, we look for what command is being inputted.
			String command = keyboard.next();
			
		
			//We check if the command is one that is followed by a number.
			if((needNumbers.indexOf(command)) >= 0)
			{
				//We assign the number to a variable for future use.
				commandNumber = keyboard.nextInt();
			}
			
			//We check if the command is one that is followed by a word.
			if((needsWords.indexOf(command)) >= 0)
			{
				//We store the word in a variable.
				newColor = keyboard.next();
			}
			
			//Basic switch statement connecting the input and the methods.
			switch(command)
			{
			case "right":
				turtle.right(commandNumber);
				break;
			case "left":
				turtle.left(commandNumber);
				break;
			case "forward":
				//Uses variable from before to repeat forward movements.
				for(int i = 0; i < commandNumber; i++)
				{
					turtle.forward();
				}
				break;
			case "pencolor":
				turtle.setPenColor(newColor);
				break;
			case "penup":
				turtle.penUp();
				break;
			case "pendown":
				turtle.penDown();
				break;
			case "quit":
				keyboard.close();
				System.exit(0);
			//Default case is used if the user enters an invalid command.
			default:
				System.out.println("Invalid command.");
				continue;
			}
		}
	}

}
