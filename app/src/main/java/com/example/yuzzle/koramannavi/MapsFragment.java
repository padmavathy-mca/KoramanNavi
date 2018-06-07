package com.example.yuzzle.koramannavi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends Fragment implements OnMapReadyCallback{
    private GoogleMap mMap;
    String x,y;

    public MapsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        x = getArguments().getString("1");
        y = getArguments().getString("2");
        String[] names = {"Tandoori Hut","CHINITA","Bistro OUI","Tella Tales"};
        int[] maxPrice = {250,400,300,300};
        int[] minPrice = {150,300,200,200};
        String[] kinds = {"Indian","Mexican","Italian","Italian"};
        double[] latitude = {12.93441,12.9543,12.8454,12.9482,};
        double[] longitude = {77.6185,77.5637,77.6324,77.6098};


        mMap=googleMap;
        for(int i=0 ; i < 4 ; i++ ){
            LatLng location;
            int selectedPrice = Integer.parseInt(x);
            if(selectedPrice <= maxPrice[i] && selectedPrice >= minPrice[i]) {
                if(y.equals(kinds[i])) {
                    location = new LatLng(latitude[i], longitude[i]);
                    mMap.addMarker(new MarkerOptions().position(location).title(names[i])
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                } else if (y.equals("Any Kind")) {
                    location = new LatLng(latitude[i], longitude[i]);
                    mMap.addMarker(new MarkerOptions().position(location).title(names[i])
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                }
            }
        }
        LatLng koramangala=new LatLng(12.9344,77.6187);
        mMap.addMarker(new MarkerOptions().position(koramangala).title("Spice Up")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(koramangala, 5));


//        LatLng koramangala=new LatLng(12.9344,77.6187);
//        MarkerOptions markerOptions = new MarkerOptions().position(koramangala).title("Spice Up Academy");
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.koraman_chan_pin);
//        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
//        mMap.addMarker(markerOptions.position(koramangala).icon(BitmapDescriptorFactory.fromResource(R.drawable.koraman_chan_pin2)));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(koramangala, 17));
//        mMap.getUiSettings().setZoomControlsEnabled(true);




    }
}
