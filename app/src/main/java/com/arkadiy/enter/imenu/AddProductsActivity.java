package com.arkadiy.enter.imenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


/**
 * Created by vadnu on 27/12/2017.
 */

public class AddProductsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prod);
    }

    public void addCategory(View view) {
        Intent i = new Intent (this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextCategory);
        String message = editText.getText().toString();
        i.putExtra("category", message);

if(message.isEmpty())
{

    return;
}


        startActivity(i);
    }
}
