package com.example.yuzzle.koramannavi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RestaurantsSearcher extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AppCompatButton b1;
    private Spinner sp1,sp2;
    private String[] price_list = {"100","200","300","400","500"};
    private String[] food_list = {"Any Kind","Indian","Chinese","Hamburger","Italian","Korean","Mexican","Tibetan"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reataurants_searcher);

        b1 = findViewById(R.id.searchbutton);


        sp1 = findViewById(R.id.spinner1);
        ArrayAdapter adapter1 = new ArrayAdapter<CharSequence>(this, R.layout.spinner_text, price_list);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(this);

        sp2 = findViewById(R.id.spinner2);
        ArrayAdapter adapter2 = new ArrayAdapter<CharSequence>(this, R.layout.spinner_text, food_list);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);
        sp2.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

//        search(null,sp1.getSelectedItem().toString(), sp2.getSelectedItem().toString());
        final String priceRange = sp1.getSelectedItem().toString();
        final String kindsOfFoods = sp2.getSelectedItem().toString();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RestaurantsSearcher.this, SearchResults.class);
                Bundle bundle = new Bundle();
                bundle.putString("price1",priceRange);
                bundle.putString("food1",kindsOfFoods);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

// by using this method, when trying pass the variables from onItemSelected method,
// the search method will be automatically implemented before touching the "search" button.

//    public void search (View view, String priceRange, String kindsOfFoods) {
//
//        Intent intent = new Intent(RestaurantsSearcher.this, SearchResults.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("price1",priceRange);
//        bundle.putString("food1",kindsOfFoods);
//        intent.putExtras(bundle);
//        startActivity(intent);
//
//    }
}
