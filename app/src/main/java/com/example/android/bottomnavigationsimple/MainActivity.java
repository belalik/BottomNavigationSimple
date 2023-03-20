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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity - thomas";

    BottomNavigationView navBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        int value = intent.getIntExtra("key2", 0);
        Log.i(TAG, "onCreate: received: "+value);

        navBottom = findViewById(R.id.bottom_nav);

        // from menu items, set home as selected
        navBottom.setSelectedItemId(R.id.home);

        navBottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_LONG).show();
                        return true;
                        //An epileksei autin tin epilogi, anoikse to antistoixo activity.
                    case R.id.emoji:
                        // epitides einai ligo diaforetikos o kwdikas dimiourgias kai aksiopoiisis tou intent
                        // se sxesi me to EmojiActivity.  Ousiastika ekteloun to idio pragma...
                        Toast.makeText(MainActivity.this, "Emoji", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(getApplicationContext(), EmojiActivity.class);
                        myIntent.putExtra("key1", "send this string from MainActivity to EmojiActivity");
                        startActivity(myIntent);
                        // katargei to 'animation' stin allagi twn activities.
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.coffee:
                        Toast.makeText(MainActivity.this, "Coffee", Toast.LENGTH_LONG).show();
                        // todo tha sizitisoume kai tha ftiaxoume intent sto ergastirio gia to trito activity ...
                        return true;

                }

                return false;
            }
        });

    }
}