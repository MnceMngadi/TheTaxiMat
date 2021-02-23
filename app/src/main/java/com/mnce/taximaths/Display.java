package com.mnce.taximaths;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Display extends AppCompatActivity {

    Context myContext;
    DataBaseHelper myDB;
    Button theBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        theBtn = (Button) findViewById(R.id.back);

        returnHome();

        ListView listView = (ListView) findViewById(R.id.List1);
        myDB = new DataBaseHelper(this);

        ListView listView2 = (ListView) findViewById(R.id.List2);
        myDB = new DataBaseHelper(this);

        ListView listView3 = (ListView) findViewById(R.id.List3);
        myDB = new DataBaseHelper(this);

        ListView listView4 = (ListView) findViewById(R.id.List4);
        myDB = new DataBaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContent();

        ArrayList<String> theList2 = new ArrayList<>();
        Cursor data2 = myDB.getListContent();

        ArrayList<String> theList3 = new ArrayList<>();
        Cursor data3 = myDB.getListContent();

        ArrayList<String> theList4 = new ArrayList<>();
        Cursor data4 = myDB.getListContent();

        if(data.getCount() == 0){

            Toast.makeText(Display.this,"The database was empty", Toast.LENGTH_LONG).show();

        }else{

            while(data.moveToNext()){

                theList.add(data.getString(0));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);

            }
        }


        if(data2.getCount() == 0){

            Toast.makeText(Display.this,"The database was empty", Toast.LENGTH_LONG).show();

        }else{

            while(data2.moveToNext()){

                theList2.add(data2.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList2);
                listView2.setAdapter(listAdapter);

            }
        }

        if(data3.getCount() == 0){

            Toast.makeText(Display.this,"The database was empty", Toast.LENGTH_LONG).show();

        }else{

            while(data3.moveToNext()){

                theList3.add(data3.getString(2));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList3);
                listView3.setAdapter(listAdapter);

            }
        }

        if(data4.getCount() == 0){

            Toast.makeText(Display.this,"The database was empty", Toast.LENGTH_LONG).show();

        }else{

            while(data4.moveToNext()){

                theList4.add(data4.getString(3));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList4);
                listView4.setAdapter(listAdapter);

            }
        }

    }

    public void returnHome(){


        theBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent save = new Intent(Display.this, SaveFare.class);
                startActivity(save);


            }
        });
    }



}
