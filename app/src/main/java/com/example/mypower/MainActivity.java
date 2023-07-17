package com.example.mypower;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Delay duration in milliseconds
    private static final long DELAY_DURATION = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configure the window to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // Create a handler
        Handler handler = new Handler();

        // Define a runnable task to be executed after the delay
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Create a new intent to start the NavigationActivity
                Intent intent = new Intent(MainActivity.this, NavigationActivity.class);

                // Start the new activity
                startActivity(intent);

                // Finish the current activity
                finish();
            }
        };

        // Post the runnable task with a delay
        handler.postDelayed(runnable, DELAY_DURATION);
    }
}
