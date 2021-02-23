package com.mnce.taximaths;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SaveFare extends AppCompatActivity {

    DataBaseHelper myDb;

    String userValue1="", userValue2="",userValue3="";
    EditText fareEdit, fromEdit, toEdit;
    ImageButton addBtn, homeBtn;
    Button theView;
    Context mainContext;
    DataBaseHelper dbObject = new DataBaseHelper(mainContext);

    public void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_fare);


        mainContext = this;
        dbObject = new DataBaseHelper(mainContext);
        dbObject.getReadableDatabase();


// creating the textbox in java
        fareEdit  = (EditText) findViewById(R.id.editText_fare);
        fromEdit = (EditText) findViewById(R.id.fromId);
        toEdit = (EditText) findViewById(R.id.toId);

        theView = (Button) findViewById(R.id.buttonView);

        homeBtn = (ImageButton) findViewById(R.id.backHome);

        addBtn = (ImageButton) findViewById(R.id.button_add);

        myDb = new DataBaseHelper(this);

        setBtnView();
        setHomeBtn();



        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = fareEdit.getText().toString();
                String b = fromEdit.getText().toString();
                String c = toEdit.getText().toString();

                if(fareEdit.length() != 0 && fromEdit.length() != 0 && toEdit.length() != 0){

                    AddData(a, b, c);
                    fareEdit.setText("");
                    fromEdit.setText("");
                    toEdit.setText("");

                }else {


                    Toast.makeText(SaveFare.this,"You must write something on the textfield come on now!!", Toast.LENGTH_LONG).show();

                }
            }
        });


    }

    public void AddData(String x, String y, String z){

        boolean insertData = myDb.addData(x, y, z);

        if(insertData == true){

            Toast.makeText(SaveFare.this,"Data is inserted!!", Toast.LENGTH_LONG).show();

        }else {

            Toast.makeText(SaveFare.this,"Nothing was inserted!!", Toast.LENGTH_LONG).show();

        }



    }

    public void setBtnView(){

        theView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaveFare.this, Display.class);
                startActivity(intent);

            }
        });

    } //end of onclick

    public void setHomeBtn(){

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(SaveFare.this, MainActivity.class);
                startActivity(home);
            }
        });

    }


}


