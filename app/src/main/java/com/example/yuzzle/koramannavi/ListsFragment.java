package com.example.yuzzle.koramannavi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListsFragment extends Fragment {
    private RecyclerView rv;
    List<Restaurants> restaurantsList;
    ListsAdapter adapter;
    RecyclerView.LayoutManager layoutManager;




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
        //success
        int[] maxPrice = {250,400,300,300};
        int[] minPrice = {150,300,200,200};
        Integer[] Icons = {R.drawable.restaurant_appearance_ex, R.drawable.restaurant_appearance_ex, R.drawable.restaurant_appearance_ex, R.drawable.restaurant_appearance_ex };
        String[] names = {"Tandoori Hut","CHINITA","Bistro OUI","Tella Tales"};
        String[] kinds = {"Indian","Mexican","Italian","Italian"};
        String[] ranges = {"150 - 250","300 - 400","200 - 300","200 - 300"};
        String[] recommends = {"Chicken Dum Biriyani(180)","Grilled Chicken Burritos(335)","Chicken Steak(280)","unknown()"};
        Integer[] meat = {R.drawable.meat_icon,R.drawable.meat_icon,R.drawable.meat_icon,R.drawable.meat_icon};
        Integer[] alcohol = {R.drawable.nothing_icon, R.drawable.nothing_icon, R.drawable.alcohol_icon, R.drawable.alcohol_icon,};
        Integer[] credit = {R.drawable.nothing_icon,R.drawable.credit_card_icon,R.drawable.nothing_icon,R.drawable.credit_card_icon,};

        restaurantsList = new ArrayList<>();
        for(int i=0 ; i < 4; i++){
            int selectedPrice = Integer.parseInt(x);
            if(selectedPrice >= maxPrice[i] || selectedPrice <= minPrice[i]){
                if(y.equals(kinds[i])) {
                    restaurantsList.add(new Restaurants(Icons[i], names[i], kinds[i], ranges[i], recommends[i], meat[i], alcohol[i], credit[i]));
                } else if (y.equals("Any Kind")){
                    restaurantsList.add(new Restaurants(Icons[i], names[i], kinds[i], ranges[i], recommends[i], meat[i], alcohol[i], credit[i]));
                }
            }
        }




        adapter = new ListsAdapter(restaurantsList);

        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
        return view;
    }

}
