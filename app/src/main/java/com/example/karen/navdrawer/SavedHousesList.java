package com.example.karen.navdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SavedHousesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_houses_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        populateListView();
    }

    private void populateListView() {
        String[] items = {"1600 W. Pennsylvania Ave. Washington DC", "919 University Dr. Riverside, CA","1200 E. California Blvd Pasadena, CA","One Microsoft Way Redmond, WA"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.text_view, items);
        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);
    }

}
