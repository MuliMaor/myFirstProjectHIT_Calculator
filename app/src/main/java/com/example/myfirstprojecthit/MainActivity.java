package com.example.myfirstprojecthit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    String activeOperator;
    int firstNumberInCalculationInt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);
    }

    public void numberButtonClickFunction(View view)
    {
        if(view instanceof Button)
        {
            Button thePressedNumberButton = (Button) view;
            String stringToAddToView = thePressedNumberButton.getText().toString();
            result.append(stringToAddToView);
        }
    }

    public void operatorButtonClickFunction(View view)
    {
        if (view instanceof Button)
        {
            String firstNumberInCalculationStr = result.getText().toString();
            firstNumberInCalculationInt = Integer.parseInt(firstNumberInCalculationStr);

            Button thePressedOperatorButton = (Button) view;
            activeOperator = thePressedOperatorButton.getText().toString();

            result.setText(null);
        }
    }

    public void equalsButtonClickFunction(View view)
    {
        if (view instanceof Button)
        {
            String secondNumberInCalculationStr = result.getText().toString();
            int secondNumberInCalculationInt = Integer.parseInt(secondNumberInCalculationStr);

            switch (activeOperator)
            {
                case "+":
                    int sum = firstNumberInCalculationInt + secondNumberInCalculationInt;
                    result.setText(String.valueOf(sum));
                    break;
                case "-":
                    int difference = firstNumberInCalculationInt - secondNumberInCalculationInt;
                    result.setText(String.valueOf(difference));
                    break;
                case "X":
                    int product = firstNumberInCalculationInt * secondNumberInCalculationInt;
                    result.setText(String.valueOf(product));
                    break;
                case "/":
                    int quotient = firstNumberInCalculationInt / secondNumberInCalculationInt;
                    result.setText(String.valueOf(quotient));
                    break;
            }
            activeOperator = null;
        }
    }
}