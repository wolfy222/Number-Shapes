package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number
    {
        int number;
        public boolean isSquare()
        {
            double squareRoot = Math.sqrt(number);
            if(squareRoot == Math.floor(squareRoot))
                return true;
            else
                return false;
        }

        public boolean isTriangular()
        {
            int x=1;
            int triangularNumber = 1;
            while (triangularNumber < number)
            {
                x++;
                triangularNumber = triangularNumber+x;
            }
            if(triangularNumber == number)
                return true;
            else
                return false;
        }
    }
    public void testNumber(View view)
    {
        EditText editText= (EditText)findViewById(R.id.editText);
        String message;
        if (editText.getText().toString().isEmpty())
        {
           message="Please enter a Number!";
        }
        else {
            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(editText.getText().toString());
            System.out.println(myNumber.isTriangular());

            if (myNumber.isSquare() && myNumber.isTriangular() == true)
                message = editText.getText().toString() + " is Square and Triangular!";
            else if (myNumber.isSquare() == true)
                message = editText.getText().toString() + " is Square but not Triangular.";
            else if (myNumber.isTriangular() == true)
                message = editText.getText().toString() + " is Triangular but not Square.";
            else
                message = editText.getText().toString() + " is neither Square nor Triangular!";
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
