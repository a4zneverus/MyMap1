package com.jakkapan.mymap;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng pt1, pt2, pt3, pt4;
    private Marker mPt1, mPt2, mPt3,mPt4;
    private LatLngBounds bounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

            pt1 = new LatLng(18.235225, 99.486144);
            pt2 = new LatLng(18.234023, 99.484271);
            pt3 = new LatLng(18.231516, 99.489582);
            pt4 = new LatLng(18.234227, 99.487436);

            mPt1 = mMap.addMarker(new MarkerOptions()
              .position(pt1)
              .title("Lpru")
              .snippet("มหาวิทยาลัย")
              .icon( BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

            mPt2 = mMap.addMarker(new MarkerOptions()
                .position(pt2)
                .title("EDU")
                .snippet("มหาวิทยาลัย")
                .icon( BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            mPt3 = mMap.addMarker(new MarkerOptions()
                .position(pt3)
                .title("WTF")
                .snippet("มหาวิทยาลัย")
                .icon( BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

            mPt4 = mMap.addMarker(new MarkerOptions()
                .position(pt4)
                .title("KILL")
                .snippet("มหาวิทยาลัย")
                .icon( BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                bounds = new LatLngBounds.Builder()
                        .include(pt1)
                        .include(pt2)
                        .include(pt3)
                        .include(pt4)
                        .build();

                final View mapview = getSupportFragmentManager()
                        .findFragmentById(R.id.map).getView();

                if (mapview.getViewTreeObserver().isAlive()){
                    mapview.getViewTreeObserver().addOnGlobalLayoutListener(
                            new ViewTreeObserver.OnGlobalLayoutListener() {
                                @Override
                                @SuppressWarnings("deprecation")
                                @SuppressLint("NewApi")
                                public void onGlobalLayout() {
                                    LatLngBounds bounds = new LatLngBounds.Builder()
                                            .include(pt1)
                                            .include(pt2)
                                            .include(pt3)
                                            .include(pt4)
                                            .build();
                                    if (Build.VERSION.SDK_INT< Build.VERSION_CODES.JELLY_BEAN) {
                                        mapview.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                    }else {
                                        mapview.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                    }
                                    mMap.moveCamera(
                                            CameraUpdateFactory.newLatLngBounds(bounds, 40)
                                    );
                                }
                            }
                    );
                }
    }



//          Add a marker in Sydney and move the camera
//        LatLng Home = new LatLng(18.236398, 98.834042);

//        mMap.addMarker(new MarkerOptions()
//              .position(Home)
//            .title("MyHome")
//          .snippet("สวนลำไย")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
//        .icon(BitmapDescriptorFactory.fromResource(R.drawable.pokemon)));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(Home));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Home, 17));
//        CameraPosition cameraPosition = new CameraPosition.Builder()
//           .target(Home)
//           .zoom(17)
//           .tilt(60)
//           .build();
//      mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//    }
}

