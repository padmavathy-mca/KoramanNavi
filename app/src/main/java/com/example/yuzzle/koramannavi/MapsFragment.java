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
    String x,selectedKind,selectedRestaurantName;

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
            mMap=googleMap;
        LatLng koramangala=new LatLng(12.9344,77.6187);
        mMap.addMarker(new MarkerOptions().position(koramangala).title("Spice Up")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(koramangala, 15));


        String[] names = {"The Himalayan Korean Restaurant", "Thalassery Restaurant", "North Indian and Bengali Mess", "Tella Tales", "Tandoori Hut", "Chinita", "Chung Wah Restaurant",
                    "Cafe Medley", "Truffles", "Bistro OUI", "Soup'ermanz Kitchen", "Shree Thali", "Hotel Tibet", "Gudguda Prime Cafe", "7 Plates", "Echoes"};
            int[] minPrice = {300,150,100,200,150,300,150,150,200,200,200,100,150,300,100,200};
            int[] maxPrice = {500,300,200,300,250,400,300,300,400,300,400,200,300,500,300,300};
            String[] kinds1 = {"Korean","Indian","Indian","Italian", "Indian", "Mexican", "Chinese", "Italian", "Italian", "Italian", "Italian","Indian", "Tibetan", "Indian", "Indian","Italian"};
            String[] kinds2 = {"Japanese","","","", "", "", "", "", "Hamburger", "", "Hamburger", "", "", "Italian","",""};
            String[] kinds3 = {"","","","", "", "", "", "", "Indian", "", "","", "", "Mexican","",""};
            double[] latitude = {12.933469, 12.937082, 12.9364, 12.933222, 12.933805, 12.93532, 12.93451,
                    12.933949, 12.933525, 12.933789, 12.936939, 12.936464, 12.934223, 12.936343, 12.934005,12.93399124};
            double[] longitude = {77.621306, 77.619663, 77.620154, 77.61396, 77.6193, 77.622396, 77.616892,
                    77.619654, 77.614282, 77.619412, 77.61842, 77.619901, 77.616049, 77.621105,77.617048,77.61556022};



            for(int i=0 ; i <names.length ; i++ ){
                LatLng location = new LatLng(latitude[i], longitude[i]);
                selectedRestaurantName = getArguments().getString("restaurant");
                x = getArguments().getString("1");
                selectedKind = getArguments().getString("2");
                int selectedPrice = Integer.parseInt(x);

                if(selectedPrice==0 && selectedKind.equals("0")){
                    if(selectedRestaurantName.equals(names[i])){
                        mMap.addMarker(new MarkerOptions().position(location).title(names[i])
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                    }
                }

                if(selectedPrice <= maxPrice[i] && selectedPrice >= minPrice[i]) {
                    if(selectedKind.equals(kinds1[i]) || selectedKind.equals(kinds2[i]) || selectedKind.equals(kinds3[i])) {
                        mMap.addMarker(new MarkerOptions().position(location).title(names[i])
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                    } else if (selectedKind.equals("Any Kind")) {
                        mMap.addMarker(new MarkerOptions().position(location).title(names[i])
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                    }

                }


            }







//        LatLng koramangala=new LatLng(12.9344,77.6187);
//        MarkerOptions markerOptions = new MarkerOptions().position(koramangala).title("Spice Up Academy");
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.koraman_chan_pin);
//        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
//        mMap.addMarker(markerOptions.position(koramangala).icon(BitmapDescriptorFactory.fromResource(R.drawable.koraman_chan_pin2)));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(koramangala, 17));
//        mMap.getUiSettings().setZoomControlsEnabled(true);




    }
}
