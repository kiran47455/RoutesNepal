package com.soch.tourismapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ViewUsers extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setMapToolbarEnabled(false);
        double latitude[] = {28.2380, 28.2385, 28.2390, 28.2320, 28.2340, 28.2318, 28.2350, 28.2399, 28.2365, 28.2360};
        double longitude[] = {83.9956, 83.9960, 83.9933, 83.9945, 83.9968, 83.9914, 83.9940, 83.9933, 83.9985, 83.9974};

        for (int i = 0; i < latitude.length; i++) {
            // Add a marker in Sydney and move the camera
            LatLng pokhara = new LatLng(latitude[i], longitude[i]);
            mMap.addMarker(new MarkerOptions().position(pokhara).title("Marker"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(pokhara));
        }
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }
}
