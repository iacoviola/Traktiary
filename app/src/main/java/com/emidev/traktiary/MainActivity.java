package com.emidev.traktiary;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.elevation.SurfaceColors;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Applying Material 3's Dynamic Colors
        DynamicColors.applyToActivityIfAvailable(this);

        // Applying to the navbar the same color of the bottom navigation view
        getWindow().setNavigationBarColor(SurfaceColors.SURFACE_2.getColor(this));

        setContentView(R.layout.activity_main);

        /* Toolbar mainToolbar = findViewById(R.id.toolbar);

        mainToolbar.setNavigationOnClickListener(v -> onBackPressed());

        MenuItem searchItem = mainToolbar.getMenu().findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.navigation_search);
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                navController.navigateUp();
                return false;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //submit to fragment
                SearchViewModel searchViewModel = new ViewModelProvider(MainActivity.this).get(SearchViewModel.class);
                searchViewModel.setText(newText);
                return false;
            }
        }); */

        //setSupportActionBar(mainToolbar);

        DrawerLayout drawer = findViewById(R.id.container);

        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mainToolbar,
                R.string.drawer_open,
                R.string.drawer_close );

        drawer.addDrawerListener(toggle);
        toggle.syncState();*/

        /* AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_movie, R.id.navigation_show, R.id.navigation_notifications)
                .setOpenableLayout(drawer)
                .build();*/

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment_activity_main);

        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        } else {
            throw new RuntimeException("navHostFragment is null");
        }

        BottomNavigationView navView = findViewById(R.id.nav_view);

        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        navView.setOnItemSelectedListener(item -> {
            NavOptions.Builder builder = new NavOptions.Builder();
            builder.setEnterAnim(androidx.navigation.ui.R.anim.nav_default_enter_anim)
                    .setExitAnim(androidx.navigation.ui.R.anim.nav_default_exit_anim);

            navController.navigate(item.getItemId(), null, builder.build());
            return true;
        });

        navView.setOnItemReselectedListener(item -> {
            //call method to refresh content
        });

        //Re write this two methods
        //NavigationUI.setupWithNavController(navView, navController);
        //NavigationUI.setupWithNavController(mainToolbar, navController, appBarConfiguration);

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == R.id.app_bar_search){
            navController.navigate(R.id.navigation_search);
        }

        return true;

    }*/

}