package com.example.niraj.shreyaguessinggame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    private EditText txtGuess;
    private Button btnGuess;
    private TextView lblOutput;
    private TextView lblTriesLeft;
    private int theNumber;
    private int triesLeft;

    public void checkGuess() {
        // Get the number the user entered
        String theirNumber = txtGuess.getText().toString();
        String message = "";
        try {

            int guess = Integer.parseInt(theirNumber);

            triesLeft--;

            if (guess > theNumber) { // too high
                message = guess + " was too high. Guess again.";

            }
            else if (guess < theNumber) { // too low
                message = guess + " was too low. Guess again.";
            }
            else {  // correct
                message = guess + " was the right number. You win! Play again!";
                newGame();
            }
            if (triesLeft <= 0) {
                message = "You lost! Correct Number was "+theNumber+" Play again!";
                newGame();
            }
            triesLeftFunct();
            lblOutput.setText(message);
        }
        catch(Exception ex) {
            message = " Please enter a whole number above.";
            lblOutput.setText(message);
        }
        finally {   // highlight the txtGuess text field
            txtGuess.requestFocus();
            txtGuess.selectAll();
        }
    }

    private void newGame() {
        triesLeft = 7;
        theNumber = (int) (Math.random() * 100 + 1);
        triesLeftFunct();
    }

    private void triesLeftFunct() {
        String message = "("+triesLeft+" tries left)";
        lblTriesLeft.setText(message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtGuess = (EditText) findViewById(R.id.txtGuess);
        btnGuess = (Button) findViewById(R.id.btnGuess);
        lblOutput = (TextView) findViewById(R.id.lblOutput);
        lblTriesLeft = (TextView) findViewById(R.id.lblTriesLeft);

        newGame();

        // setup the event listener for our guess button.
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkGuess();
            }
        });

        // set up the event listener for out input field
        txtGuess.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                checkGuess();
                return true;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Shreya's Guessing Game");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
