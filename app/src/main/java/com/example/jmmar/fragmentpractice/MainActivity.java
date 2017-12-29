package com.example.jmmar.fragmentpractice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FrameLayout mFragmentContainer1;
    private FrameLayout mFragmentContainer2;
    private FragmentManager mFragmentManager;
    public static final String FRAG_ONE_TAG = "FirstFragment";
    public static final String FRAG_TWO_TAG = "SecondFragment";
    public static final String FRAG_THREE_TAG = "ThreeFragment";
    public static final String FRAG_SHOW_ALL = "ShowAllFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mFragmentContainer1 = (FrameLayout) findViewById(R.id.frag_container_one);
        mFragmentContainer2 = (FrameLayout) findViewById(R.id.frag_container_two);

        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_all_frags:
                mFragmentManager.beginTransaction().replace(R.id.big_fragment_container,
                        new ShowAllFragment(),FRAG_SHOW_ALL).commit();
                break;

            case R.id.nav_frag1:
                mFragmentManager.beginTransaction().add(R.id.big_fragment_container,
                        new FirstFragment().newInstance("New Frag One Title"),FRAG_ONE_TAG).commit();
                break;

            case R.id.nav_frag2:
                mFragmentManager.beginTransaction().add(R.id.big_fragment_container,
                        new SecondFragment(),FRAG_TWO_TAG).commit();
                break;

            case R.id.nav_frag3:
                mFragmentManager.beginTransaction().add(R.id.big_fragment_container,
                        new ThirdFragment(),FRAG_THREE_TAG).commit();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
