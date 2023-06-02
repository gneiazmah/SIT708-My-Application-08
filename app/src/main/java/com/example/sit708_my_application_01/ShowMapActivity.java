package com.example.sit708_my_application_01;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    MapView mapView;
    GoogleMap googleMap;
    Marker marker;

    double latitude = -29.465303000;
    double longitude = 149.8415676;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_map);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        LatLng latLng = new LatLng(latitude, longitude);
        marker = googleMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));


        LatLng location1 = new LatLng(-38.1492994, 144.3598426);
        googleMap.addMarker(new MarkerOptions().position(location1).title("Marker 1"));

        LatLng location2 = new LatLng(-35.8136276, 144.963057599999);
        googleMap.addMarker(new MarkerOptions().position(location2).title("Marker 2"));

        LatLng location3 = new LatLng(-33.868819699, 151.2092955);
        googleMap.addMarker(new MarkerOptions().position(location3).title("Marker 3"));

        LatLng location4 = new LatLng(-27.4704528, 153.0260341);
        googleMap.addMarker(new MarkerOptions().position(location4).title("Marker 4"));

        LatLng location5 = new LatLng(-22.575197, 144.0847926);
        googleMap.addMarker(new MarkerOptions().position(location5).title("Marker 5"));

        LatLng location6 = new LatLng(-35.28001903, 149.1310038);
        googleMap.addMarker(new MarkerOptions().position(location6).title("Marker 6"));

        LatLng location7 = new LatLng(-31.2532182999, 146.921099);
        googleMap.addMarker(new MarkerOptions().position(location7).title("Marker 7"));

        // Show latitude and longitude values when marker is clicked
        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String message = "Latitude: " + marker.getPosition().latitude
                        + "\nLongitude: " + marker.getPosition().longitude;
                Toast.makeText(ShowMapActivity.this, message, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}