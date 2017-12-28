package com.arkadiy.enter.imenu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private int x;
    private Button btn_calc;
    private String numCalc;
    private TextView screenCalc;

    private LinkedList <String> lightDrinks;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = null;
        prefs = getSharedPreferences("com.arkadiy.enter.imenu", MODE_PRIVATE);


        screenCalc = (TextView)findViewById(R.id.editTextScreenCalc);
        productName = new LinkedList<String>();


        dataConfig=new DataConfig(this);
         productsDB=dataConfig.getWritableDatabase();
        dataConfig.setDb(productsDB);
          listView=(ListView)findViewById(R.id.listViewPrice);

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


//dataConfig.createNewProductsTable("beers");
              ;



//          Cursor cursor=productsDB.rawQuery("SELECT _id, drinkName FROM light_drinks",null);
//          String [] columns={cursor.getColumnName(1)};
//
//          int [] desplayViews={R.id.listViewPrice};
//        cursorAdapter= new SimpleCursorAdapter(
//                this,
//                       R.layout.list_item,
//                       cursor,
//                       columns,
//                       displayViews,
//                       0
//        );
//
//        listView.setAdapter(cursorAdapter);


        TextView text=(TextView)findViewById(R.id.textView2);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
//            boolean isNew = extras.getBoolean("category",false);
            if (true) {
                String inte=getIntent().getExtras().getString("category");
                text.setText(inte);
                dataConfig.createNewProductsTable(inte);
                flag=false;

            }
            else
            {
                text.setText("nothing ");
                flag=false;
            }
        }
        else{
            text.setText("nothing yet");
        }



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

public void changeProduct(String product){
    productName=dataConfig.getDataFromDataBase(product);
    fillInMenue(productName);
}


    public void loadAll(View v) {


        switch (v.getId()) {
            case R.id.beers:
                changeProduct("beers");
                flag = true;
                break;


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

    public void fillInMenue(LinkedList <String> products) {   //adds products to menue from database

        if (flag)
        {
            layout.removeAllViews();
            flag=false;
        }


        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i);
            Button tempBut = new Button(MainActivity.this);

            tempBut.setText(name);
            layout = (GridLayout) findViewById(R.id.gridTest);
            layout.addView(tempBut);


        }
    }


    public void addToCategoriesLayout(){//adds categories to top  scrollbar (linear layout) from database

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

public void goToAddProd(View view){
    Intent i = new Intent (this, AddProductsActivity.class);
    startActivity(i);
}

}
