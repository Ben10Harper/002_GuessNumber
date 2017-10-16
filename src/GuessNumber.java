import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GuessNumber {

	//"Field" Very important is "Scope"
	//"Public" means any other class has access; usually BAD!!
	//"Private" means only used inside of this class; usually this is very good!
	//"Protected" means can be used by any other class in this package
	private int lowerLimit = 0;
	private int upperLimit = 10;
	
	Random rand = new Random();
	
	Scanner keyboard = new Scanner(System.in);

	/*
	 * 1. set lower and upper bounds on the number, like 0 - 10 
	 * 2. pick a random in that range 
	 * 3. start looping 
	 * -- guess 
	 * -- check for win 
	 * -- if win congrats!
	 * --if no win repeat 
	 * --set a guess limit, like after 5 tries game over
	 */

	// "field" variables -- put ALL your vars up top
	// making it super easy to change things
	// as you keep figuring out the beset way for your code to work

	// next, constructor(s) -- you can have more than one constructor
	// that would be called a constructor "stack"

	public GuessNumber() {

	} // end of constructor

	public void startGame() {
		
		Boolean gameRunning = true;
		int guess;
		int countLimit = 5;
		String startMsg = "";
		String enterGuess = "";
		
		// get a new random number
		// example of "method scope" --- can ONLY exist inside of this method
		int answer = rand.nextInt(upperLimit) + lowerLimit;
		//System.out.println("for testing answer = " + answer);
		startMsg = "...for testing answer = " + answer;
		JOptionPane.showMessageDialog(null, startMsg);
		
		//upper limit -1 because its exclusive, stops 1 number before
		
		//later: test for bounds
		
		//ok check for a win
		// YO! Pay Attention! == is a test operator, ALWAYS used in if's
		
		while (gameRunning && countLimit > 0) {
			//System.out.println("\nPlease enter your guess between " +lowerLimit + " and " + (upperLimit - 1));
			enterGuess = "Please enter your guess between " +lowerLimit + " and " + (upperLimit - 1);
			
			//guess = keyboard.nextInt();
			guess = Integer.parseInt(JOptionPane.showInputDialog(enterGuess));
			//System.out.println("\nGuess = " + guess + "\n");
		
			//test -- remove once we see everything works
			//System.out.println("Testing: countLimit = " + countLimit);
			
		if (guess == answer) {
			
			//System.out.println("Congrats!! You won!");
			JOptionPane.showMessageDialog(null, "Congrats!! You won!");
			gameRunning = false;
			
		} else if (guess < answer) {
			
			//System.out.println("Sorry, too low!");
			JOptionPane.showMessageDialog(null, "Sorry, too low!");
			
		} else if (guess > answer) {
			
			//System.out.println("Sorry, too high!");
			JOptionPane.showMessageDialog(null, "Sorry, too high!");
			
			
		} else {
			
			//System.out.println("What? I dont understand!");
			JOptionPane.showMessageDialog(null, "What? I dont understand!");
			
		}
			
			countLimit--;
			
		} // end of while
	
		if (countLimit > 2) {
			//System.out.println("You're AMAZING!!");
			JOptionPane.showMessageDialog(null, "You're AMAZING!!");
		}else if (countLimit > 0 && countLimit < 3) {
			//System.out.println("You're pretty good!");
			JOptionPane.showMessageDialog(null, "You're pretty good!");
		}else if (countLimit == 0 && gameRunning == true) {
			//System.out.println("You lose!");
			JOptionPane.showMessageDialog(null, "You lose!");
		}else if (countLimit == 0) {
			//System.out.println("Phew! Barely made it!");
			JOptionPane.showMessageDialog(null, "Phew! Barely made it!");
		}
		
	} // end of startGame()

} // end of class
