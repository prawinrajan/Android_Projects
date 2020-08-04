package com.mydreamworld.mapinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;

    LocationListener locationListener;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            stratListening();
        }
    }

    public void stratListening(){
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        }
    }
    public void updateLocationInfo(Location location) throws IOException {
        Log.i("locationinfo", location.toString());

        TextView latitude=(TextView) findViewById(R.id.latitude);

        TextView longtu=(TextView) findViewById(R.id.longtu);

        TextView accuracy=(TextView) findViewById(R.id.accuracy);

        TextView altitude=(TextView) findViewById(R.id.altitude);

        TextView Address=(TextView) findViewById(R.id.Address);

        latitude.setText("Latitude: "+location.getLatitude());
        longtu.setText("Longtitude: "+location.getLongitude());
        accuracy.setText("Accuracy: "+location.getAccuracy());
        altitude.setText("Altitude: "+location.getAltitude());

        String address="";
        Geocoder geocoder=new Geocoder(getApplicationContext(), Locale.getDefault());
        List<Address> addressList=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
        if(addressList!=null && addressList.size()>0){
            Log.i("placeInfo",addressList.get(0).toString());
            if(addressList.get(0).getSubThoroughfare()!=null){
                address+=addressList.get(0).getSubThoroughfare()+" ";
            }
            if(addressList.get(0).getThoroughfare()!=null){
                address+=addressList.get(0).getThoroughfare()+"\n ";
            }
            if(addressList.get(0).getLocality()!=null){
                address+=addressList.get(0).getLocality()+"\n ";
            }
            if(addressList.get(0).getPostalCode()!=null){
                address+=addressList.get(0).getPostalCode()+"\n ";
            }
            if(addressList.get(0).getCountryName()!=null){
                address+=addressList.get(0).getCountryName()+"\n ";
            }

        }
        Address.setText(address);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                try {
                    updateLocationInfo(location);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if (Build.VERSION.SDK_INT < 23) {
            stratListening();
        }else{
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            }else{
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
                Location location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location!=null){
                    try {
                        updateLocationInfo(location);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
