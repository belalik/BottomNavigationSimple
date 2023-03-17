package com.example.android.bottomnavigationsimple;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navBottom = findViewById(R.id.bottom_nav);

        navBottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.emoji:
                        Toast.makeText(MainActivity.this, "Emoji", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(MainActivity.this, EmojiActivity.class);
                        myIntent.putExtra("key", "something");
                        MainActivity.this.startActivity(myIntent);
                        return true;
                    case R.id.coffee:
                        Toast.makeText(MainActivity.this, "Coffee", Toast.LENGTH_LONG).show();
                        return true;

                }

                return false;
            }
        });

    }
}