package com.batuta.traillogger;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private Fragment mFragmentSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        mNavigationView = (NavigationView) findViewById(R.id.activity_main_drawer_navigation_view);
        mNavigationView.inflateMenu(R.menu.navigation_items);
        mNavigationView.setNavigationItemSelectedListener(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.activity_main_drawer_container, new LogFragment())
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.side_bar_menu_item_add_details:
                mFragmentSwitch = new DetailsFragment();
                break;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_drawer_container, mFragmentSwitch)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("DetailsFragment")
                .commit();
        mDrawerLayout.closeDrawers();
        return false;
    }
}
