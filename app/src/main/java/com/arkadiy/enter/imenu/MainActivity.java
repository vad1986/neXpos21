package com.arkadiy.enter.imenu;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private String calcString="";
    private TextView textViewScreenCalc;
    private boolean ifHaveDot=false;
    private ListView listViewSummary;
    private ArrayAdapter<String> listAdapter;


    private Button btn_calc;
    private String numCalc;
    private TextView screenCalc;

    private LinkedList<String> lightDrinks;
    private  LinkedList <String> beers;
    private static boolean flag = false;
    private GridLayout layout;
    private LinearLayout layout2=null;
    private  LinkedList<String> productName;


    private static DataConfig dataConfig=null;
    //    private static SQLiteDatabase productsDB=null;
    private static SimpleCursorAdapter cursorAdapter=null;
    private static ListView listView=null;
    private SQLiteDatabase productsDB=null;
    private GridLayout gLayout =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = (GridLayout) findViewById(R.id.gridLayoutItem);
        gLayout= new GridLayout(this);

        if(Math.pow(getScreenHeight(),2)+Math.pow(getScreenWidth(),2)>10)
        {
            RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.relattiveLayoutL);
            gLayout.setColumnCount(4);
            relativeLayout.addView(gLayout);

        }
        else{
            gLayout.setColumnCount(3);

        }

        setContentView(R.layout.activity_main);
        SharedPreferences prefs = null;

        textViewScreenCalc = (TextView)findViewById(R.id.textViewScreenCalc);
        listViewSummary = (ListView)findViewById(R.id.listViewSummary);
        listViewSummary.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,new ArrayList<String>()));
        listAdapter = (ArrayAdapter<String>)listViewSummary.getAdapter();





        productName = new LinkedList<String>();


        dataConfig=new DataConfig(this);
        productsDB=dataConfig.getWritableDatabase();
        dataConfig.setDb(productsDB);
        prefs = getSharedPreferences("com.arkadiy.enter.imenu", MODE_PRIVATE);


        if(prefs.getBoolean("firstrun", true)) //checks if app runs first time
        {
            dataConfig.setInsertQuery2("beers", "גולדסטאר", (float) 10.90);
            dataConfig.setInsertQuery2("beers", "היניקן", (float) 9.90);
            dataConfig.setInsertQuery2("beers", "קורונה", (float) 11.90);
            dataConfig.setInsertQuery2("beers", "קארלסברג", (float) 12.90);
            dataConfig.setInsertQuery2("beers", "מכאבי", (float) 15.93);

            dataConfig.createNewProductsTable("light_drinks");
            dataConfig.setInsertQuery2("light_drinks", "קולה", (float) 10.90);
            dataConfig.setInsertQuery2("light_drinks", "ספרייט", (float) 9.90);
            dataConfig.setInsertQuery2("light_drinks", "סודה", (float) 11.90);
            dataConfig.setInsertQuery2("light_drinks", "אינגדי", (float) 12.90);
            dataConfig.setInsertQuery2("light_drinks", "תפוחים", (float) 15.93);

            prefs.edit().putBoolean("firstrun", false).commit();

        }



    }



    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }




    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {



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



    public void loadAll(View v) {


        switch (v.getId()) {
//            case R.id.beers:
//                changeProduct("beers");
//                flag = true;
//                break;


            case R.id.light:
                changeProduct("light_drinks");
                flag = true;
                break;


            default:
                if (flag)
                {
                    layout.removeAllViews();
                    flag=false;
                }

                break;


        }


    }


    public void changeProduct(String product){
        productName=dataConfig.getDataFromDataBase(product);
        fillInMenue(productName);
    }



    public void fillInMenue(LinkedList <String> products) {   //adds products to menue from database
          int length=products.size();
        if (flag)
        {
            layout.removeAllViews();
            flag=false;
        }


        for (int i = 0; i < length; i++) {
            String name = products.get(i);
            Button tempBut = new Button(MainActivity.this);
            tempBut.setLayoutParams(new ViewGroup.LayoutParams(150, 80));
            tempBut.setText(name);
            tempBut.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view){
//                    printName(name);
                }
            });
            layout = (GridLayout) findViewById(R.id.gridLayoutItem);

            layout.addView(tempBut);


        }
    }


    public void adjustButtonSize(Button button) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        ViewGroup.LayoutParams params = button.getLayoutParams();
        params.height = height / 10;         // 10%
        params.width = ((width * 20) / 100); // 20%
        button.setLayoutParams(params);
    }




}








