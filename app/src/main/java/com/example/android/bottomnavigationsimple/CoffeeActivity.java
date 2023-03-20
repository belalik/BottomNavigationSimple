package com.example.android.bottomnavigationsimple;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CoffeeActivity extends AppCompatActivity {

    private static final String TAG = "CoffeeActivity - thomas";

    BottomNavigationView navBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        Intent intent = getIntent();
        String value = intent.getStringExtra("key1");
        Log.i(TAG, "onCreate: received: "+value);

        navBottom = findViewById(R.id.bottom_nav);

        // from menu items, set emojis as selected
        navBottom.setSelectedItemId(R.id.emoji);

        navBottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(CoffeeActivity.this, "Home", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(CoffeeActivity.this, MainActivity.class);
                        // apothikeuw kai "stelnw" tin timi 15 (int) sto MainActivity
                        myIntent.putExtra("key2", 15);
                        CoffeeActivity.this.startActivity(myIntent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.emoji:
                        Toast.makeText(CoffeeActivity.this, "Emoji", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.coffee:
                        Toast.makeText(CoffeeActivity.this, "Coffee", Toast.LENGTH_LONG).show();
                        return true;
                }

                return false;
            }
        });
    }
}