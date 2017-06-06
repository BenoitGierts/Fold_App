package com.foldapp.hcattiaux.foldapp;

/**
 * Created by jdavid on 16/03/17.
 */

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class MapFragment extends SupportMapFragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private LatLng adress;
    double  latitude;
    double longitude;
    List<Address> addresses;
    String location = "4 rue merlin Paris";
    private int PERMISSION_GEO;




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Geocoder geocoder = new Geocoder(getContext());
        try {
            addresses = geocoder.getFromLocationName(location,1);
            while (addresses.size() == 0){
                addresses = geocoder.getFromLocationName(location,1);
            }

            latitude = addresses.get(0).getLatitude();
            longitude = addresses.get(0).getLongitude();

        } catch (IOException e) {
            e.printStackTrace();
        }

        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (latitude != 0 & longitude != 0) {
            adress = new LatLng(latitude, longitude);
            mMap.addMarker(new MarkerOptions().position(adress).title("Marker location"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(adress, 15));
        }
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            mMap.setMyLocationEnabled(true);
        }



    }

}