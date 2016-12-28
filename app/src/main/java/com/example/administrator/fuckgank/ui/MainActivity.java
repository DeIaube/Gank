package com.example.administrator.fuckgank.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.fuckgank.R;
import com.example.administrator.fuckgank.base.BaseActivity;
import com.example.administrator.fuckgank.ui.category.CategoryFragment;
import com.example.administrator.fuckgank.ui.exciting.ExcitingFragment;
import com.example.administrator.fuckgank.ui.search.SearchActivity;
import com.example.administrator.fuckgank.ui.today.TodayFragment;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void init() {
//        i(String.valueOf(drawerLayout == null));
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
        replaceFragment(R.id.fragment_container, TodayFragment.newInstance(), TodayFragment.TAG);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.nav_today:
                replaceFragment(R.id.fragment_container, TodayFragment.newInstance(), TodayFragment.TAG);
                break;
            case R.id.nav_android:
                replaceFragment(R.id.fragment_container, CategoryFragment.newInstance(CategoryFragment.Android), CategoryFragment.Android);
                break;
            case R.id.nav_ios:
                replaceFragment(R.id.fragment_container, CategoryFragment.newInstance(CategoryFragment.iOS), CategoryFragment.iOS);
                break;
            case R.id.nav_front_end:
                replaceFragment(R.id.fragment_container, CategoryFragment.newInstance(CategoryFragment.front), CategoryFragment.front);
                break;
            case R.id.nav_video:
                replaceFragment(R.id.fragment_container, CategoryFragment.newInstance(CategoryFragment.video), CategoryFragment.video);
                break;
            case R.id.nav_welfare:
                replaceFragment(R.id.fragment_container, ExcitingFragment.newInstance(), ExcitingFragment.TAG);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            SearchActivity.start(this);
        }
        return super.onOptionsItemSelected(item);
    }

}
