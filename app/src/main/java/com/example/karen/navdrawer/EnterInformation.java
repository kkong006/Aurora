package com.example.karen.navdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditText address = (EditText) findViewById(R.id.Address);
        EditText price = (EditText) findViewById(R.id.Price);
        EditText size = (EditText) findViewById(R.id.dimensions);
        EditText rooms = (EditText) findViewById(R.id.Rooms);
        EditText info = (EditText) findViewById(R.id.info);

        Button add = (Button) findViewById(R.id.add);
        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            public void onClick(View v) {

                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.eje_c.rajawalicardboard");
                startActivity(launchIntent);
            }
        };
        add.setOnClickListener(oclBtnOk);
        //  String newValue = etUserInfoNewValue.getText().toString().trim();


    }
}