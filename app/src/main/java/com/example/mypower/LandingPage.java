package com.example.mypower;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class LandingPage extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Find the navigation drawer menu items by their IDs
        MenuItem homeMenuItem = navigationView.getMenu().findItem(R.id.home);
        MenuItem newApplMenuItem = navigationView.getMenu().findItem(R.id.new_appl);
        MenuItem feedbackMenuItem = navigationView.getMenu().findItem(R.id.feed_back);
        MenuItem failureMenuItem = navigationView.getMenu().findItem(R.id.power_failure);
        MenuItem billtokenMenuItem= navigationView.getMenu().findItem(R.id.bill_token);
        MenuItem aboutMenuItem = navigationView.getMenu().findItem(R.id.about_a);
        MenuItem faqsMenuItem = navigationView.getMenu().findItem(R.id.faqs);


        // Set OnClickListener for each menu item
        homeMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        newApplMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NewApplicationsFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        feedbackMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FeedbackFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        failureMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ReportFailureFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        billtokenMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MybillTokenFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        aboutMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragmentFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        faqsMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FAQSFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
