package com.example.karen.navdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MapsInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button tour = (Button)findViewById(R.id.Tour);
        View.OnClickListener oclBtnOk = new View.OnClickListener()
        {
            public void onClick(View v)
            {

                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.eje_c.rajawalicardboard");
                startActivity(launchIntent);
            }
        };
        tour.setOnClickListener(oclBtnOk);

    }

}