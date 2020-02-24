package com.example.bdiverse.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.bdiverse.Fragment.Done;
import com.example.bdiverse.Fragment.Inbox;
import com.example.bdiverse.Fragment.Open;
import com.example.bdiverse.Fragment.Settings;
import com.example.bdiverse.Fragment.Updates;
import com.example.bdiverse.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements Open.OnFragmentOpenListener ,Done.OnFragmentDonenListener,Inbox.OnFragmenInboxListener,Settings.OnFragmentSettingsListener,Updates.OnFragmentUpdatesListener {
    BottomNavigationView bottomNavigation;
    View open;
    View done;
    View updates;
    View inbox;
    View settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openFragment(Open.newInstance());
        initViewOfNavigationbar();

       bottomNavigation = findViewById(R.id.am_bottom_navigation);
       bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);



    }

    public void openFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
        .replace(R.id.ma_fremlayout, fragment)
        .addToBackStack(null)
        .commit();
    }
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_open:
                    visbilityitem(open);
                    openFragment(Open.newInstance());
                    return true;
                case R.id.action_done:
                    visbilityitem(done);
                    openFragment(Done.newInstance());
                    return true;
                case R.id.action_updates:
                    visbilityitem(updates);
                    openFragment(Updates.newInstance());
                    return true;
                case R.id.action_index:
                    visbilityitem(inbox);
                    openFragment(Inbox.newInstance());
                    return true;
                case R.id.action_sottings:
                    visbilityitem(settings);
                    openFragment(Settings.newInstance());
                    return true;
            }

            return false;
        }
    };

    private void initViewOfNavigationbar() {
        open = findViewById(R.id.ma_tab_open);
        done = findViewById(R.id.ma_tab_done);
        updates = findViewById(R.id.ma_tab_updates);
        inbox = findViewById(R.id.ma_tab_inbox);
        settings = findViewById(R.id.ma_tab_setings);
    }

    public void visbilityitem(View view){
        open.setVisibility(View.INVISIBLE);
        done.setVisibility(View.INVISIBLE);
        updates.setVisibility(View.INVISIBLE);
        inbox.setVisibility(View.INVISIBLE);
        settings.setVisibility(View.INVISIBLE);

        view.setVisibility(View.VISIBLE);

    }




    @Override
    public void fargmentDone() {

    }

    @Override
    public void fragmentInbox() {

    }

    @Override
    public void FragmentSettings() {

    }

    @Override
    public void FragmentUpdates() {

    }

    @Override
    public void FragmentOpen() {

    }
}
