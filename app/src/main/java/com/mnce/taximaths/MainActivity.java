package com.mnce.taximaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //@Override
    ImageButton buttonCalc;
    ImageButton exitButton;
    ImageButton save;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalc = (ImageButton) findViewById(R.id.calculateId);
        buttonCalc.setOnClickListener(this);

        exitButton = (ImageButton) findViewById(R.id.exit);
        exitButton.setOnClickListener(this);

        save = (ImageButton) findViewById(R.id.savedId);
        save.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.calculateId) {

            Intent calculateActivity = new Intent(this, Calculate.class);
            startActivity(calculateActivity);

        }else if(v.getId() == R.id.savedId ){

            Intent saveActivity = new Intent(this, SaveFare.class);
            startActivity(saveActivity);


        }else{


            moveTaskToBack(true);


        }



    }


}
