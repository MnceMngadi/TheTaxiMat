package com.mnce.taximaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Change extends AppCompatActivity implements View.OnClickListener{

    // @Override

    ImageButton backBtn;
    ImageButton save;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);


        Intent intent = getIntent();
        String data = intent.getStringExtra("Extra_Message");
        TextView theView = findViewById(R.id.displayId);
        theView.setText(data);

        Intent intent2 = getIntent();
        String thisChange = intent2.getStringExtra("The_Change");
        TextView changeTextView = findViewById(R.id.changeDisplayId);
        changeTextView.setText(thisChange);

        backBtn = (ImageButton) findViewById(R.id.backHome);
        backBtn.setOnClickListener(this);

        save = (ImageButton) findViewById(R.id.calculateId);
        save.setOnClickListener(this);

    }

    public void onClick(View v){

        if(v.getId() == R.id.backHome) {
            Intent theBack = new Intent(this, Calculate.class);
            startActivity(theBack);

        }else if(v.getId() == R.id.calculateId) {

            Intent theSave = new Intent(this, SaveFare.class);
            startActivity(theSave);


        }



    }


}
