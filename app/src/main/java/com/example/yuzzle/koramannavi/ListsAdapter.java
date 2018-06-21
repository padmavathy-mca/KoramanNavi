package com.example.yuzzle.koramannavi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by yuzzle on 2018/05/30.
 */

public class ListsAdapter extends RecyclerView.Adapter<ListsAdapter.ListsViewHolder> {

    List<Restaurants> restaurantsList;

    ListsFragment listsFragment;
    private Context context;
    FragmentManager fragmentManager;
    Fragment fragment;
    FragmentTransaction transaction;
    String price,kind;

    public ListsAdapter(Context context,List<Restaurants> restaurantsList) {
        this.context=context;
        this.restaurantsList = restaurantsList;
    }

    @Override
    public ListsAdapter.ListsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_lists, parent, false);


        listsFragment = new ListsFragment();
        return new ListsViewHolder(view);

    }

    //
//    public void loadRestaurants(List<Restaurants> restaurantsList) {
//        this.restaurantsList = restaurantsList;
//        notifyDataSetChanged();
//    }

    @Override
    public void onBindViewHolder(ListsAdapter.ListsViewHolder holder, final int position) {
//        Restaurants restaurants = restaurantsList.get(position);
        //
        //Glide.with(context).load(restaurantsList.get(position).getAppearance());
        holder.restaurantAppearances.setImageResource(restaurantsList.get(position).getAppearance());
        holder.restaurantAppearances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager =((AppCompatActivity)context).getSupportFragmentManager();
                fragment = new RestaurantImagesFragment();
                Bundle bun = new Bundle();
                bun.putString("restaurant", restaurantsList.get(position).getName().toString());
                fragment.setArguments(bun);
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.commit();
            }
        });

        holder.name.setText(restaurantsList.get(position).getName());
        holder.kind.setText(restaurantsList.get(position).getKind());
        String minimumPrice = String.valueOf(restaurantsList.get(position).getMinprice());
        String maximumPrice = String.valueOf(restaurantsList.get(position).getMaxprice());
        holder.minPrice.setText(minimumPrice);
        holder.maxPrice.setText(maximumPrice);
        holder.meat.setImageResource(restaurantsList.get(position).getMeatAvailable());
        holder.alcohol.setImageResource(restaurantsList.get(position).getAlcoholAvailable());
        holder.credit.setImageResource(restaurantsList.get(position).getCreditAvailable());
        holder.mapmarker.setImageResource(restaurantsList.get(position).getMapMarkerLink());
        holder.mapmarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager =((AppCompatActivity)context).getSupportFragmentManager();
                fragment = new MapsFragment();
                //for passing the values
                Bundle bundle1 = new Bundle();
                bundle1.putString("1","0");
                bundle1.putString("2","0");
                bundle1.putString("restaurant", restaurantsList.get(position).getName().toString());
                fragment.setArguments(bundle1);
                //for passing the values
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.commit();
            }
        });

    }


    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }

    public class ListsViewHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView restaurantAppearances;
        private ImageView meat, alcohol, credit;
        private AppCompatTextView name,kind,minPrice,maxPrice;
        private ImageButton mapmarker;

        public ListsViewHolder(View itemView) {
            super(itemView);

            restaurantAppearances = itemView.findViewById(R.id.pic1);
            name = itemView.findViewById(R.id.text1);
            kind = itemView.findViewById(R.id.text2);
            minPrice = itemView.findViewById(R.id.text3);
            maxPrice = itemView.findViewById(R.id.text4);
            meat = itemView.findViewById(R.id.icon1);
            alcohol = itemView.findViewById(R.id.icon2);
            credit = itemView.findViewById(R.id.icon3);
            mapmarker = itemView.findViewById(R.id.mapbutton);

        }
    }
}
