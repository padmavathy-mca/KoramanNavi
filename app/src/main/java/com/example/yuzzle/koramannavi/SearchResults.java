package com.example.yuzzle.koramannavi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.TextView;

public class SearchResults extends AppCompatActivity {

    FragmentManager fragmentManager;
    Fragment fragment;
    FragmentTransaction transaction;
    String a,b;
    ListsAdapter adapter;

    //for checking if this activity could get the variable from the spinners in researcher
    TextView textView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_map:;
                    fragment = new MapsFragment();
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("1",a);
                    bundle1.putString("2",b);
                    fragment.setArguments(bundle1);
                    transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.container, fragment);
                    transaction.commit();
                    return true;

                case R.id.navigation_list:
                    fragment = new ListsFragment();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("1",a);
                    bundle2.putString("2",b);
                    fragment.setArguments(bundle2);
                    transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.container, fragment);
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



        //for checking => success
        textView = findViewById(R.id.text1);
        Intent i = getIntent(); //importは後々削除してね
        a = i.getStringExtra("price1");
        b = i.getStringExtra("food1");
        textView.setText(a+" , "+b);

//for ListsAdapter
//        Intent intent = new Intent(SearchResults.this, ListsAdapter.class);
//       intent.putExtra("1",a);
//        intent.putExtra("2",b);
//        Bundle bundleForAdapter = new Bundle();
//        bundleForAdapter.putString("1",a);
//        bundleForAdapter.putString("2",b);
//        intent.putExtras(bundleForAdapter);
//for ListsAdapter

        fragmentManager = getSupportFragmentManager();
        fragment = new MapsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("1",a);
        bundle.putString("2",b);
        fragment.setArguments(bundle);
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();

    }
//    public void openMap() {
//        fragmentManager = getSupportFragmentManager();
//        fragment = new MapsFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("1",a);
//        bundle.putString("2",b);
//        fragment.setArguments(bundle);
//        transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.container, fragment);
//        transaction.commit();
//    }
}
