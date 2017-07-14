import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;	// Text field for the user's guess
	private JLabel lblOutput;	// Label for too high/too low output
	private int theNumber; // the number we're trying to guess
	private int triesLeft = 7;
	
	public void checkGuess() { 	// method/function to check too high or too low
		// get the user's guess
		String guessText = txtGuess.getText();
		String message = "";	
		
		// check the guess for too high/too low
		try {			
		
			int guess = Integer.parseInt(guessText);
			
			//count this as one try
			triesLeft--;			
			
			// too high
			if (guess > theNumber) 
			{
				message = guess + " was too high. You have " + triesLeft + " tries left!";
				//lblOutput.setText(message);
			} 
			else if (guess < theNumber)
			{
				message = guess + " was too low. You have " + triesLeft + " tries left!";
				//lblOutput.setText(message);
			}
			else
			{
				message = guess + " was right! You win.";
				newGame();
			}
			
			if (triesLeft <= 0) {
				message = "Sorry! You ran out of tries! The number was "+ theNumber +". Play again!";
				javax.swing.JOptionPane.showConfirmDialog(null, message);
				newGame();
				message = "Choose a number between 1-100 in 7 tries!";
			}
			
			lblOutput.setText(message);
		} catch (Exception e) {
			lblOutput.setText("Enter a whole number between 1 and 100.");
		} finally {
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
		
	}
	
	public void newGame() { // create a new random number 1...100
		theNumber = (int)(Math.random()*100 + 1);
		triesLeft = 7;
	}
	
	public GuessingGame() {
		getContentPane().setForeground(new Color(255, 204, 204));
		setForeground(new Color(255, 204, 204));
		setTitle("Shreya's Guessing Game");
		getContentPane().setBackground(new Color(255, 0, 102));
		setBackground(new Color(255, 0, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNirajHiloGuessing = new JLabel("Shreya's Hi-Lo Guessing Game");
		lblNirajHiloGuessing.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNirajHiloGuessing.setBounds(0, 12, 440, 35);
		lblNirajHiloGuessing.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNirajHiloGuessing);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 102));
		panel.setBounds(26, 74, 372, 44);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGuessANumber = new JLabel("Guess a Number between 1 and 100: ");
		lblGuessANumber.setBounds(23, 22, 263, 15);
		panel.add(lblGuessANumber);
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setBounds(290, 19, 56, 19);
		panel.add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(174, 170, 117, 25);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number! You have 7 tries!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 219, 438, 25);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(430, 330));
		
		theGame.setVisible(true);

	}
}
