package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void guessPressed(View view) {
        EditText numberGuessed = (EditText) findViewById(R.id.editText);
        int guessNumber = Integer.parseInt(numberGuessed.getText().toString());


        if (guessNumber>0 && guessNumber<21) {
            if (guessNumber>randomNumber) {
                Toast.makeText(this, "Lower!", Toast.LENGTH_SHORT).show();
            }
            else if (guessNumber<randomNumber) {
                Toast.makeText(this, "Higher!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "You guessed it right! Try again!", Toast.LENGTH_SHORT).show();
                Random r = new Random();
                randomNumber = r.nextInt(20-1+1) + 1;
            }
        }
        else {
            Toast.makeText(this, "Out of bounds guess", Toast.LENGTH_SHORT).show();
        }
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();
        randomNumber = r.nextInt(20-1+1) + 1;
    }
}
