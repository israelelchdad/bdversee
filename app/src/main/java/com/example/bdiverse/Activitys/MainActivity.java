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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Open.OnFragmentOpenListener ,Done.OnFragmentDonenListener,Inbox.OnFragmenInboxListener,Settings.OnFragmentSettingsListener,Updates.OnFragmentUpdatesListener {
    BottomNavigationView bottomNavigation;
    ArrayList<View> listOfViewOfNavigatiobar;
    private Fragment myFragmentOpen;
    private Fragment myFragmentDone;
    private Fragment myFragmentUpdates;
    private Fragment myFragmentIndex;
    private Fragment myFragmentSetings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openFragment(Open.newInstance());
        initViewOfNavigationbar();
        chengeColorOfStatusBar();
        bottomNavigation = findViewById(R.id.am_bottom_navigation);
        initLisitnerOfNavigation();




    }

    private void initLisitnerOfNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_open:
                    visbilityitem(0);
                    if(myFragmentOpen ==null){
                        myFragmentOpen = Open.newInstance();
                    }
                    openFragment(myFragmentOpen);
                    return true;
                case R.id.action_done:
                    visbilityitem(1);
                    if(myFragmentDone == null){
                        myFragmentDone = Done.newInstance();
                    }
                    openFragment(myFragmentDone);
                    return true;
                case R.id.action_updates:
                    visbilityitem(2);
                    if (myFragmentUpdates == null) {

                        myFragmentUpdates=Updates.newInstance();
                    }
                    openFragment(myFragmentUpdates);
                    return true;
                case R.id.action_index:
                    visbilityitem(3);
                    if(myFragmentIndex==null){
                        myFragmentIndex=Inbox.newInstance();
                    }
                    openFragment(myFragmentIndex);
                    return true;
                case R.id.action_sottings:
                    visbilityitem(4);
                    if(myFragmentSetings == null){
                        myFragmentSetings= Settings.newInstance();
                    }
                    openFragment(myFragmentSetings);
                    return true;
            }

            return false;
        }
    };

    public void openFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ma_fremlayout, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void initViewOfNavigationbar() {
        listOfViewOfNavigatiobar= new ArrayList<>();
        listOfViewOfNavigatiobar.add(findViewById(R.id.ma_tab_open));
        listOfViewOfNavigatiobar.add(findViewById(R.id.ma_tab_done));
        listOfViewOfNavigatiobar.add(findViewById(R.id.ma_tab_updates));
        listOfViewOfNavigatiobar.add(findViewById(R.id.ma_tab_inbox));
        listOfViewOfNavigatiobar.add( findViewById(R.id.ma_tab_setings));

    }


    public void visbilityitem(int index){
        for (int i = 0; i <listOfViewOfNavigatiobar.size() ; i++) {
            if(i!=index){
                listOfViewOfNavigatiobar.get(i).setVisibility(View.INVISIBLE);
            }
            else {
                listOfViewOfNavigatiobar.get(i).setVisibility(View.VISIBLE);
            }

        }


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
