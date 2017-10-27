package com.kapibary.naratunek.activity;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.kapibary.naratunek.R;
import com.kapibary.naratunek.adapters.MainDrawerListAdapter;
import com.kapibary.naratunek.entity.NavigationItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mDrawerList;
    RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    ArrayList <NavigationItem> navigationItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationItems = new ArrayList<>();

        navigationItems.add(new NavigationItem("Uzytkownik", "Lokalizacja", 0));
        navigationItems.add(new NavigationItem("Wiadomosci", "", 0));
        navigationItems.add(new NavigationItem("Historia wplat", "", 0));
        navigationItems.add(new NavigationItem("Ustawienia", "", 0));
        //navigationItems.add(new NavigationItem("Ustawienia", "", R.drawable.ic_action_about));

        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Populate the Navigtion Drawer with options
        mDrawerPane = (RelativeLayout) findViewById(R.id.content_frame);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        MainDrawerListAdapter adapter = new MainDrawerListAdapter(this, navigationItems);
        mDrawerList.setAdapter(adapter);


        // Drawer Item click listeners
       /* mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }
        }); */


    }


    /*
* Called when a particular item from the navigation drawer
* is selected.
* */
    private void selectItemFromDrawer(int position) {
        /*Fragment fragment = new PreferencesFragment();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        mDrawerList.setItemChecked(position, true);
        setTitle(navigationItems.get(position).getmTitle());

        // Close the drawer
        mDrawerLayout.closeDrawer(mDrawerPane); */
    }
}
