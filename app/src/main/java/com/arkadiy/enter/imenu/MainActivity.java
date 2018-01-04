package com.arkadiy.enter.imenu;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String calcString="";
    private TextView textViewScreenCalc;
    private boolean ifHaveDot=false;
    private ListView listViewSummary;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textViewScreenCalc = (TextView)findViewById(R.id.textViewScreenCalc);
        listViewSummary = (ListView)findViewById(R.id.listViewSummary);
        listViewSummary.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,new ArrayList<String>()));
        listAdapter = (ArrayAdapter<String>)listViewSummary.getAdapter();
    }

    public void calc_onClick(View view) {
        switch (view.getId())
        {
            case R.id.button0:
                calcString+="0";
                textViewScreenCalc.setText(calcString);
                break;
            case R.id.button1:
                calcString+="1";
                textViewScreenCalc.setText(calcString);
                break;
            case R.id.button2:
                calcString+="2";
                textViewScreenCalc.setText(calcString);
                break;
            case R.id.button3:
                calcString+="3";
                textViewScreenCalc.setText(calcString);
                break;
            case R.id.button4:
                calcString+="4";
                textViewScreenCalc.setText(calcString);
                break;
            case R.id.button5:
                calcString+="5";
                textViewScreenCalc.setText(calcString);
                break;
            case R.id.button6:
                calcString+="6";
                textViewScreenCalc.setText(calcString);
                break;
            case R.id.button7:
                calcString+="7";
                textViewScreenCalc.setText(calcString);
                break;
            case R.id.button8:
                calcString+="8";
                textViewScreenCalc.setText(calcString);
                break;
            case R.id.button9:
                calcString+="9";
                textViewScreenCalc.setText(calcString);
                break;
            case R.id.buttonC:
                calcString="";
                ifHaveDot = false;
                textViewScreenCalc.setText(calcString);
                break;
            case R.id.buttonDot:
                if(!ifHaveDot) {
                    calcString += ".";
                    ifHaveDot = true;
                }
                break;
            case R.id.buttonEnter:
                listAdapter.add(calcString);
                calcString="";
                textViewScreenCalc.setText(calcString);
                ifHaveDot = false;
                break;
        }
    }
}








