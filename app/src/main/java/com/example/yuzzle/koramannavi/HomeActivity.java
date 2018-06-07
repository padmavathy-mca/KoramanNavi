package com.example.yuzzle.koramannavi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_home);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent1 = new Intent(HomeActivity.this, RestaurantsSearcher.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(HomeActivity.this, StoresSearcher.class);
                startActivity(intent2);
                break;
        }
    }
}
