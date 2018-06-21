package com.example.yuzzle.koramannavi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListsFragment extends Fragment {
    ApiInterface apiInterface;
    private RecyclerView rv;
    List<Restaurants> restaurantsList;
    ListsAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private TextView nothingText;
    String[] names;

    public ListsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lists, container, false);


        rv = view.findViewById(R.id.recycleview);
        String x= getArguments().getString("1");
        String y= getArguments().getString("2");

        restaurantsList = new ArrayList<>();

        //success
        Integer[] Icons = {R.drawable.the_himalayan_korean_restaurant_1, R.drawable.thalassery_restaurant_1, R.drawable.north_indian_and_bangali_mess, R.drawable.tella_tales_1,
                           R.drawable.tandoori_hut_1, R.drawable.chinita_1, R.drawable.chung_wah_restaurant_1, R.drawable.cafe_medley_1, R.drawable.truffles_1,
                           R.drawable.bistro_oui_1, R.drawable.soupermanz_kitchen_1, R.drawable.shree_thali_1, R.drawable.hotel_tibet_1, R.drawable.gudguda_prime_cafe_1,
                           R.drawable.seven_plates_1,R.drawable.echoes_1};
        names = new String[]{"The Himalayan Korean Restaurant", "Thalassery Restaurant", "North Indian and Bengali Mess", "Tella Tales", "Tandoori Hut", "Chinita", "Chung Wah Restaurant",
                "Cafe Medley", "Truffles", "Bistro OUI", "Soup'ermanz Kitchen", "Shree Thali", "Hotel Tibet", "Gudguda Prime Cafe", "7 Plates","Echoes"};

        String[] kinds1 = {"Korean","Indian","Indian","Italian", "Indian", "Mexican", "Chinese", "Italian", "Italian", "Italian", "Italian","Indian", "Tibetan", "Indian", "Indian","Italian"};
        String[] kinds2 = {"","","","", "", "", "", "", "Hamburger", "", "Hamburger", "", "", "Italian","",""};
        String[] kinds3 = {"","","","", "", "", "", "", "Indian", "", "","", "", "Mexican","",""};

        int[] minimum = {300,150,100,200,150,300,150,150,200,200,200,100,150,300,100,200};
        int[] maximum = {500,300,200,300,250,400,300,300,400,300,400,200,300,500,300,300};
        Integer[] meat = {R.drawable.meat_ok_icon, R.drawable.meat_ok_icon, R.drawable.meat_ok_icon, R.drawable.meat_ok_icon, R.drawable.meat_ok_icon, R.drawable.meat_ok_icon,
                          R.drawable.meat_ok_icon, R.drawable.meat_ok_icon, R.drawable.meat_ok_icon, R.drawable.meat_ok_icon, R.drawable.meat_ok_icon, R.drawable.meat_no_icon,
                          R.drawable.meat_ok_icon, R.drawable.meat_ok_icon, R.drawable.meat_ok_icon, R.drawable.meat_ok_icon};
        Integer[] alcohol = {R.drawable.alcohol_ok_icon, R.drawable.alcohol_no_icon, R.drawable.alcohol_no_icon, R.drawable.alcohol_ok_icon, R.drawable.alcohol_no_icon, R.drawable.alcohol_unknown_icon,
                             R.drawable.alcohol_unknown_icon, R.drawable.alcohol_no_icon, R.drawable.alcohol_unknown_icon, R.drawable.alcohol_ok_icon, R.drawable.alcohol_no_icon, R.drawable.alcohol_no_icon,
                             R.drawable.alcohol_no_icon, R.drawable.alcohol_no_icon, R.drawable.alcohol_no_icon, R.drawable.alcohol_unknown_icon};
        Integer[] credit = {R.drawable.credit_ok_icon, R.drawable.credit_no_icon, R.drawable.credit_no_icon, R.drawable.credit_ok_icon, R.drawable.credit_unknown_icon, R.drawable.credit_ok_icon,
                             R.drawable.credit_ok_icon, R.drawable.credit_ok_icon, R.drawable.credit_ok_icon, R.drawable.credit_no_icon, R.drawable.credit_ok_icon, R.drawable.credit_no_icon,
                             R.drawable.credit_no_icon, R.drawable.credit_ok_icon, R.drawable.credit_ok_icon, R.drawable.credit_ok_icon};
        restaurantsList = new ArrayList<>();
        int itemCount = 0;
        for(int i=0 ; i < names.length ; i++){
            int selectedPrice = Integer.parseInt(x);
            if(selectedPrice >= minimum[i]){
                if(y.equals(kinds1[i]) || y.equals(kinds2[i]) || y.equals(kinds3[i])) {
                    restaurantsList.add(new Restaurants(Icons[i], names[i], kinds1[i]+" "+kinds2[i]+" "+kinds3[i], minimum[i], maximum[i], meat[i], alcohol[i], credit[i], R.drawable.map_marker2));

                    itemCount++;
                } else if (y.equals("Any Kind")){
                    restaurantsList.add(new Restaurants(Icons[i], names[i], kinds1[i]+" "+kinds2[i]+" "+kinds3[i], minimum[i], maximum[i], meat[i], alcohol[i], credit[i], R.drawable.map_marker2));
                    itemCount++;
                }
            }
        }
        if(itemCount == 0) {
            nothingText = view.findViewById(R.id.notFoundText);
            nothingText.setText("Sorry, No Restaurant Found");
        }


        adapter = new ListsAdapter(getContext(),restaurantsList);
//        apiInterface=ApiClient.getInstance().create(ApiInterface.class);
//
//
        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        rv.setAdapter(adapter);
//        loadRestaurantsData();
        return view;
    }


//    private void loadRestaurantsData() {
//        Call<List<Restaurants>> listCall = apiInterface.getRestaurants();
//        listCall.enqueue(new Callback<List<Restaurants>>() {
//            @Override
//            public void onResponse(Call<List<Restaurants>> call, Response<List<Restaurants>> response) {
//                restaurantsList = response.body();
//                listsAdapter.loadRestaurants(restaurantsList);
//            }
//
//            @Override
//            public void onFailure(Call<List<Restaurants>> call, Throwable t) {
//
//            }
//        });
//    }

}
