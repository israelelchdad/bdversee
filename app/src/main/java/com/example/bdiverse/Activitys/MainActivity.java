package com.example.bdiverse.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

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
        chengeColorOfStatusBar();

       bottomNavigation = findViewById(R.id.am_bottom_navigation);
       bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);



    }

    private void chengeColorOfStatusBar() {
        Window window = getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(this.getResources().getColor(R.color.chengstatusbar));

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
