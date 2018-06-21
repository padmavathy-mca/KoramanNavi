package com.example.yuzzle.koramannavi;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yuzzle on 2018/06/15.
 */

public class RestaurantImagesAdapter extends RecyclerView.Adapter<RestaurantImagesAdapter.ListViewHolder>{


    List<RestaurantImagesItems> restaurantImagesItems;
    Fragment fragment;
    private Context context;
    RestaurantImagesFragment restaurantImagesFragment;

    public RestaurantImagesAdapter(Context c, List<RestaurantImagesItems> row) {
        context = c;
        restaurantImagesItems = row;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_restaurant_single, parent, false);

        restaurantImagesFragment = new RestaurantImagesFragment();
        return new ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.images.setImageResource((restaurantImagesItems.get(position).getRestauranImage()));
        holder.images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.imageNames.setText(restaurantImagesItems.get(position).getImageName());
    }

    @Override
    public int getItemCount() {
        return restaurantImagesItems.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView images;
        private TextView imageNames;

        public ListViewHolder(View itemView) {
            super(itemView);

            images = itemView.findViewById(R.id.imageview);
            imageNames = itemView.findViewById(R.id.textview);
        }
    }
}
