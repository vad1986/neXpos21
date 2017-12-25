package com.arkadiy.enter.imenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int x;
    private Button btn_calc;
    private String numCalc;
    private TextView screenCalc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenCalc = (TextView)findViewById(R.id.editTextScreenCalc);
        numCalc="";

    }
    public void calc_onClick(View view){
        switch (view.getId()){
            case R.id.buttonNumber0:
                numCalc+="0";
                screenCalc.setText(numCalc);
                break;
            case R.id.buttonNumber1:
                numCalc+="1";
                screenCalc.setText(numCalc);
                break;
            case R.id.buttonNumber2:
                numCalc+="2";
                screenCalc.setText(numCalc);
                break;
            case R.id.buttonNumber3:
                numCalc+="3";
                screenCalc.setText(numCalc);
                break;
            case R.id.buttonNumber4:
                numCalc+="4";
                screenCalc.setText(numCalc);
                break;
            case R.id.buttonNumber5:
                numCalc+="5";
                screenCalc.setText(numCalc);
                break;
            case R.id.buttonNumber6:
                numCalc+="6";
                screenCalc.setText(numCalc);
                break;
            case R.id.buttonNumber7:
                numCalc+="7";
                screenCalc.setText(numCalc);
                break;
            case R.id.buttonNumber8:
                numCalc+="8";
                screenCalc.setText(numCalc);
                break;
            case R.id.buttonNumber9:
                numCalc+="9";
                screenCalc.setText(numCalc);
                break;
            case R.id.buttonEnter:
                double prise = Double.parseDouble(numCalc);
                numCalc="";
                screenCalc.setText(numCalc);
                break;
            case R.id.buttonDot:
                numCalc+=".";
                screenCalc.setText(numCalc);
                break;
        }
    }



}
