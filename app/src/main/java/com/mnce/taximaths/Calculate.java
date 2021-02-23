package com.mnce.taximaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Calculate extends AppCompatActivity  implements View.OnClickListener {



    ImageButton buttonBack;
    ImageButton calculate;
    EditText editText1;
    EditText editText2;
    EditText editText3;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        editText1 = (EditText) findViewById(R.id.editText_fare);
        editText2 = (EditText) findViewById(R.id.fromId);
        editText3 = (EditText) findViewById(R.id.receivedAmount);


        calculate = (ImageButton) findViewById(R.id.calculateId);
        calculate.setOnClickListener(this);
        buttonBack = (ImageButton) findViewById(R.id.backHome);
        buttonBack.setOnClickListener(this);
    }

    public void onClick(View view){

        if(view.getId() == R.id.backHome) {

            Intent goBack = new Intent(this, MainActivity.class);
            startActivity(goBack);



        }else if(view.getId() == R.id.calculateId){

            if(editText1.length() !=0 && editText2.length() !=0 && editText3.length() !=0) {
                int pasengers = 0;
                double fareAmount = 0.00;
                double amountReceived = 0.00;
                double change = 0.00;

                pasengers = Integer.parseInt(editText1.getText().toString());
                fareAmount = Double.parseDouble(editText2.getText().toString());
                amountReceived = Double.parseDouble(editText3.getText().toString());

                change = amountReceived - (fareAmount * pasengers);

                editText1.setText("");
                editText3.setText("");


                String p = Integer.toString(pasengers);
                String f = Double.toString(fareAmount);
                String a = Double.toString(amountReceived);
                String c = Double.toString(change);

                Intent changeActivity = new Intent(this, Change.class);
                changeActivity.putExtra("Extra_Message", "No Of Passengers: " + p + "\n\n\nTaxi Amount        : R " + f + "\n\n\nMoney Received  : R " + a);
                changeActivity.putExtra("The_Change", "\nChange is           : R  " + c);
                startActivity(changeActivity);

            }else {

                Toast.makeText(Calculate.this,"You must write something on the textfield come on now!!", Toast.LENGTH_LONG).show();

            }

        }

    }



}
