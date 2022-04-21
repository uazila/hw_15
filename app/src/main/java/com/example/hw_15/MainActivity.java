package com.example.hw_15;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private TextView tv_result;
    private Integer firstVar;
    private Integer secondVar;
    private boolean isOperationClick;
    private String operation;
    private Integer result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result = findViewById(R.id.text_view);
    }

    public void setNumber(String number) {
        if (tv_result.getText().toString().equals("0")) {
            tv_result.setText(number);
        } else if (isOperationClick) {
            tv_result.setText(number);
        } else {
            tv_result.append(number);
        }
        isOperationClick = false;
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_zero:
                setNumber("0");
                break;
            case R.id.btn_clear:
                tv_result.setText("0");
                isOperationClick = false;
                firstVar = 0;
                secondVar = 0;
                break;

        }
        isOperationClick = false;
    }

    @SuppressLint("SetTextI18n")
    public void onOperationClick(View view) {

        switch (view.getId()) {
            case R.id.btn_plus:
                firstVar = Integer.parseInt(tv_result.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.btn_minus:
                firstVar = Integer.parseInt(tv_result.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;
            case R.id.btn_multiply:
                firstVar = Integer.parseInt(tv_result.getText().toString());
                isOperationClick = true;
                operation = "X";
                break;
            case R.id.btn_divide:
                firstVar = Integer.parseInt(tv_result.getText().toString());
                isOperationClick = true;
                operation = "/";
                break;

            case R.id.btn_percent:
                firstVar = Integer.parseInt(tv_result.getText().toString());
                int result_percent = 0;
                isOperationClick = true;
                result_percent = firstVar / 100;
                tv_result.setText(new DecimalFormat("##.#######").format(result_percent));
                break;

            case R.id.btn_value:
                firstVar = Integer.parseInt(tv_result.getText().toString());
                int result_value = 0;
                isOperationClick = true;
                result_value = firstVar *= -1;
                tv_result.setText(new DecimalFormat("##.#######").format(result_value));
                break;


            case R.id.btn_equal:
                secondVar = Integer.parseInt(tv_result.getText().toString());
                result = 0;
                switch (operation) {
                    case "+":
                        result = firstVar + secondVar;
                        break;

                    case "-":
                        result = firstVar - secondVar;
                        break;

                    case "X":
                        result = firstVar * secondVar;
                        break;

                    case "/":
                        result = firstVar / secondVar;
                        break;
                }
                tv_result.setText(Integer.toString(result));
                isOperationClick = true;
                break;
        }
    }
}