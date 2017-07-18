import java.util.Scanner;

public class HiLo {

	public static void main(String[] args) {
		
		// get ready for the player to use the keyboard
		
		Scanner scan = new Scanner(System.in);
		
		// Play again string
		
		String playAgain = "";
		
		// game loop		
		do {
		
			//Create a random number from 1-100
			int theNumber = (int)(Math.random() * 100 + 1);
			
			int guess = 0;
			
			// Number of tries to guess the correct number
			int numOfTries = 0;			
			
			while ( guess != theNumber ) {
				System.out.println("Guess a number between 1 and 100: ");				
				
				try {
					// get the user's guess
					guess = scan.nextInt();
					
					numOfTries++;
					
					if (guess < theNumber) {
						
						System.out.println(guess + " is too low. Try again.");
						
					} else if (guess > theNumber) {
						
						System.out.print(guess + " is too high. Try again.");
						
					} else {
						
						System.out.println(guess + " is correct! You win!");
						System.out.println("It only took you " + numOfTries + " tries! Good Work!");
						
					}
				} catch (Exception e) {
					System.out.println("Please input a valid number between 1 and 100");
					scan.nextLine();
				}	
				
			} // end of while loop for guessing
			// ask for 'y' to play again.
			System.out.println("Would you like to play again (y/n)?");
			
			playAgain = scan.next();				
			
			
		} while (playAgain.equalsIgnoreCase("y"));
		
		scan.close();
		
		// thank the user for playing.
		System.out.println("Thank you for playing! Goodbye.");
	}

}
