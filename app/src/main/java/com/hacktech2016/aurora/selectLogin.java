package com.hacktech2016.aurora;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class selectLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login);

        Button client_login = (Button) findViewById(R.id.client_login_bt);
        client_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(selectLogin.this, LoginActivity.class);
                startActivity(i);
            }
        });
        Button realtor_login = (Button) findViewById(R.id.realtor_login_bt);
        realtor_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(selectLogin.this, LoginActivityRealtor.class);
                startActivity(i);
            }
        });

    }

}
