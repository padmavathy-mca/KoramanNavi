package com.example.yuzzle.koramannavi;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by yuzzle on 2018/05/30.
 */

public class ListsAdapter extends RecyclerView.Adapter<ListsAdapter.ListsViewHolder> {

    List<Restaurants> restaurantsList;

    public ListsAdapter(List<Restaurants> restaurantsList) {
        this.restaurantsList = restaurantsList;
    }

    @Override
    public ListsAdapter.ListsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_lists, parent, false);
        return new ListsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListsAdapter.ListsViewHolder holder, int position) {
//        Restaurants restaurants = restaurantsList.get(position);

        holder.restaurantAppearances.setImageResource(restaurantsList.get(position).getAppearance());
        holder.name.setText(restaurantsList.get(position).getName());
        holder.kind.setText(restaurantsList.get(position).getKind());
        holder.range.setText(restaurantsList.get(position).getRange());
        holder.recommend.setText(restaurantsList.get(position).getRecommend());
        holder.meat.setImageResource(restaurantsList.get(position).getMeatAvailable());
        holder.alcohol.setImageResource(restaurantsList.get(position).getAlcoholAvailable());
        holder.credit.setImageResource(restaurantsList.get(position).getCreditAvailable());

    }


    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }

    public class ListsViewHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView restaurantAppearances;
        private ImageView meat, alcohol, credit;
        private AppCompatTextView name,kind,range,recommend;

        public ListsViewHolder(View itemView) {
            super(itemView);

            restaurantAppearances = itemView.findViewById(R.id.pic1);
            name = itemView.findViewById(R.id.text1);
            kind = itemView.findViewById(R.id.text2);
            range = itemView.findViewById(R.id.text3);
            recommend = itemView.findViewById(R.id.text4);
            meat = itemView.findViewById(R.id.icon1);
            alcohol = itemView.findViewById(R.id.icon2);
            credit = itemView.findViewById(R.id.icon3);



        }
    }
}
