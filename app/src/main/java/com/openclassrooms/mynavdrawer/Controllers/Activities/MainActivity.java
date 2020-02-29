package com.openclassrooms.mynavdrawer.Controllers.Activities;

import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import com.openclassrooms.mynavdrawer.Controllers.Fragments.NewsFragment;
import com.openclassrooms.mynavdrawer.Controllers.Fragments.ParamsFragment;
import com.openclassrooms.mynavdrawer.Controllers.Fragments.ProfileFragment;
import com.openclassrooms.mynavdrawer.R;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //FOR DESIGN
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    //FOR FRAGMENTS
    // 1 - Declare fragment handled by Navigation Drawer
    private Fragment fragmentNews;
    private Fragment fragmentProfile;
    private Fragment fragmentParams;

    //FOR DATAS
    // 2 - Identify each fragment with a number
    private static final int FRAGMENT_NEWS = 0;
    private static final int FRAGMENT_PROFILE = 1;
    private static final int FRAGMENT_PARAMS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 6 - Configure all views

        this.configureToolBar();

        this.configureDrawerLayout();

        this.configureNavigationView();
    }



    // ---------------------
    // FRAGMENTS
    // ---------------------

    // 5 - Show fragment according an Identifier

    private void showFragment(int fragmentIdentifier){
        switch (fragmentIdentifier){
            case FRAGMENT_NEWS :
                this.showNewsFragment();
                break;
            case FRAGMENT_PROFILE:
                this.showProfileFragment();
                break;
            case FRAGMENT_PARAMS:
                this.showParamsFragment();
                break;
            default:
                break;
        }
    }


    // 4 - Create each fragment page and show it

    private void showNewsFragment(){
        if (this.fragmentNews == null) this.fragmentNews = NewsFragment.newInstance();
        this.startTransactionFragment(this.fragmentNews);
    }

    private void showParamsFragment(){
        if (this.fragmentParams == null) this.fragmentParams = ParamsFragment.newInstance();
        this.startTransactionFragment(this.fragmentParams);
    }

    private void showProfileFragment(){
        if (this.fragmentProfile == null) this.fragmentProfile = ProfileFragment.newInstance();
        this.startTransactionFragment(this.fragmentProfile);
    }

    // 3 - Generic method that will replace and show a fragment inside the MainActivity Frame Layout
    private void startTransactionFragment(Fragment fragment){
        if (!fragment.isVisible()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main_frame_layout, fragment).commit();
        }
    }


    @Override
    public void onBackPressed() {
        // 5 - Handle back click to close menu
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // 4 - Handle Navigation Item Click
        int id = item.getItemId();

        switch (id){
            case R.id.activity_main_drawer_news :
                break;
            case R.id.activity_main_drawer_profile:
                break;
            case R.id.activity_main_drawer_settings:
                break;
            default:
                break;
        }

        this.drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    // ---------------------
    // CONFIGURATION
    // ---------------------

    // 1 - Configure Toolbar
    private void configureToolBar(){
        this.toolbar =  findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
    }

    // 2 - Configure Drawer Layout
    private void configureDrawerLayout(){
        this.drawerLayout = findViewById(R.id.activity_main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    // 3 - Configure NavigationView
    private void configureNavigationView(){
        this.navigationView = (NavigationView) findViewById(R.id.activity_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}