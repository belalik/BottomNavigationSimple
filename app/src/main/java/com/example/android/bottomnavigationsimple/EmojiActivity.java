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

public class EmojiActivity extends AppCompatActivity {

    private static final String TAG = "EmojiActivity - thomas";

    BottomNavigationView navBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);

        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        Log.i(TAG, "onCreate: received: "+value);

        navBottom = findViewById(R.id.bottom_nav);

        navBottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(EmojiActivity.this, "Home", Toast.LENGTH_LONG).show();
                        Intent myIntent = new Intent(EmojiActivity.this, MainActivity.class);
                        EmojiActivity.this.startActivity(myIntent);
                        return true;
                    case R.id.emoji:
                        Toast.makeText(EmojiActivity.this, "Emoji", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.coffee:
                        Toast.makeText(EmojiActivity.this, "Coffee", Toast.LENGTH_LONG).show();
                        return true;
                }

                return false;
            }
        });
    }
}