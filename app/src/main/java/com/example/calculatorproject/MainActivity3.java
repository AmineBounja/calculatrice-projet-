package com.example.calculatorproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import android.view.Menu;
public class MainActivity3 extends AppCompatActivity {

    private TextView solutionTv, resultTv;
    private StringBuilder currentExpression = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Initialize TextViews
        solutionTv = findViewById(R.id.solution_tv);
        resultTv = findViewById(R.id.result_tv);

        // Set up the button to navigate to MainActivity4
        MaterialButton buttonGoToMain4 = findViewById(R.id.button_go_to_main4);
        buttonGoToMain4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        // Assign button listeners for calculator functionality
        assignButtonListeners();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void assignButtonListeners() {
        int[] buttonIds = {
                R.id.button_c, R.id.button_open_bracket, R.id.button_close_bracket, R.id.button_divide,
                R.id.button_multiply, R.id.button_addition, R.id.button_minus, R.id.button_equal,
                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4,
                R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9,
                R.id.button_ac, R.id.button_dot
        };

        for (int id : buttonIds) {
            MaterialButton button = findViewById(id);
            button.setOnClickListener(this::onButtonClick);
        }
    }

    private void onButtonClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "AC":
                currentExpression.setLength(0);
                resultTv.setText("0");
                break;

            case "=":
                calculateResult();
                break;

            case "C":
                if (currentExpression.length() > 0) {
                    currentExpression.deleteCharAt(currentExpression.length() - 1);
                }
                break;

            default:
                currentExpression.append(buttonText);
                break;
        }

        solutionTv.setText(currentExpression.toString());
    }

    private void calculateResult() {
        try {
            String expression = currentExpression.toString();
            double result = evaluateExpression(expression);
            resultTv.setText(String.valueOf(result));
        } catch (Exception e) {
            resultTv.setText("Error");
        }
    }

    private double evaluateExpression(String expression) {
        double result = 0.0;
        char[] tokens = expression.toCharArray();
        double currentValue = 0.0;
        char lastOperator = '+';

        for (char token : tokens) {
            if (Character.isDigit(token)) {
                currentValue = currentValue * 10 + (token - '0');
            } else {
                result = applyOperation(result, currentValue, lastOperator);
                currentValue = 0.0;
                lastOperator = token;
            }
        }
        result = applyOperation(result, currentValue, lastOperator);
        return result;
    }

    private double applyOperation(double result, double currentValue, char operator) {
        switch (operator) {
            case '+':
                return result + currentValue;
            case '-':
                return result - currentValue;
            case '*':
                return result * currentValue;
            case '/':
                if (currentValue != 0) {
                    return result / currentValue;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                return result;
        }
    }
}
