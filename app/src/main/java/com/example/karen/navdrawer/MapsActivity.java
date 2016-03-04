package com.example.karen.navdrawer;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {


    SupportMapFragment sMapFragment;
    Button item;
    EditText loctext;
    Button geobutton;
    Button markerbutton;
    double lat;
    double lng;
    String location;
    GoogleMap googleMap;
    private GoogleMap mMap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sMapFragment = SupportMapFragment.newInstance();

        setContentView(R.layout.activity_maps);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //item = (Button)findViewById(R.id.buttonmap);
        loctext = (EditText)findViewById(R.id.edit);
        geobutton = (Button)findViewById(R.id.geobutton);
        markerbutton = (Button)findViewById(R.id.markerbutton);
        sMapFragment.getMapAsync(this);
        FragmentManager fm = getFragmentManager();
        android.support.v4.app.FragmentManager mFm = getSupportFragmentManager();
//        View.OnClickListener oclBtnOk = new View.OnClickListener()
//        {
//            public void onClick(View v)
//            {
                //android.support.v4.app.FragmentManager mFm = getSupportFragmentManager();
                mFm.beginTransaction().add(R.id.map2, sMapFragment).commit();
                //    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                geobutton.setVisibility(View.VISIBLE);
                loctext.setVisibility(View.VISIBLE);
                markerbutton.setVisibility(View.VISIBLE);
//            }
//        };
        //item.setOnClickListener(oclBtnOk);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void geo(View v) throws IOException
    {
        InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(loctext.getWindowToken(), 0);
        EditText et = (EditText)findViewById(R.id.edit);
        location =et.getText().toString();
        Toast.makeText(this,location,Toast.LENGTH_LONG).show();
        Geocoder gc = new Geocoder(this);
        List<Address> list = gc.getFromLocationName(location,1);
        Address add = list.get(0);
        String locality = add.getLocality();
        //Toast.makeText(this,locality,Toast.LENGTH_LONG).show();
        lat = add.getLatitude();
        lng = add.getLongitude();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 10);
        mMap.animateCamera(cameraUpdate);
    }
    public void onLocationChanged(Location location) {
        MarkerOptions mp = new MarkerOptions();
        mp.position(new LatLng(location.getLatitude(), location.getLongitude()));
        mp.title("my position");

    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(38, -122);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in California"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        markerbutton = (Button)findViewById(R.id.markerbutton);
        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            public void onClick(View v) {
                LatLng real = new LatLng(lat, lng);
                mMap.addMarker(new MarkerOptions().position(real));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(real));
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    public boolean onMarkerClick(Marker arg0) {
                        Intent intent1 = new Intent(MapsActivity.this, MapsInfoActivity.class);
                        startActivity(intent1);
                        return true;
                    }
                });

            }
        };
        markerbutton.setOnClickListener(oclBtnOk);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker arg0) {
                Intent intent1 = new Intent(MapsActivity.this, MapsInfoActivity.class);
                startActivity(intent1);
                return true;
            }
        });


    }

}