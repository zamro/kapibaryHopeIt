package com.kapibary.naratunek.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kapibary.naratunek.Fragments.ClickableFragment;
import com.kapibary.naratunek.Fragments.HistoryFragment;
import com.kapibary.naratunek.Fragments.MainMenuFragment;
import com.kapibary.naratunek.R;
import com.kapibary.naratunek.adapters.MainDrawerListAdapter;
import com.kapibary.naratunek.Fragments.MessagesFragment;
import com.kapibary.naratunek.entity.NavigationItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final FragmentManager fragmentManager = getFragmentManager();
    private ClickableFragment mActiveFragment;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private ActionBar mActionBar;
    ArrayList <NavigationItem> navigationItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateNavigationItems();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mActionBar = getSupportActionBar();

        mDrawerList.setAdapter(new MainDrawerListAdapter(this, navigationItems));

        mActionBar.setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        ) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
                mActionBar.setTitle("Na Ratunek");
            }
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
                mActionBar.setTitle("Menu");
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("LOL", "navigation clicked");
            }
        });
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        // Drawer Item click listeners
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }
        });

        mActiveFragment = new MainMenuFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, mActiveFragment)
                .commit();
    }

    private void generateNavigationItems() {
        navigationItems = new ArrayList<>();
        navigationItems.add(new NavigationItem("Użytkownik", "Wrocław, Polska", 0)); //todo - localization - dynamic or from registration
        navigationItems.add(new NavigationItem("Wiadomości", "", 0));
        navigationItems.add(new NavigationItem("Historia wpłat", "", 0));
        navigationItems.add(new NavigationItem("Ustawienia", "", 0));
        navigationItems.add(new NavigationItem("TempPayment", "", 0));
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private final ClickableFragment[] fragments = {new MainMenuFragment(), new MessagesFragment(), new HistoryFragment(), new MainMenuFragment()};
    private void selectItemFromDrawer(int position) {
        Log.d("DRAWER", "" + position);
        if(position == 4) {
            Intent i = new Intent(this, TempActivity.class);
            startActivity(i);
        }
        else
        {
            mActiveFragment = fragments[position];
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, mActiveFragment)
                    .commit();

            mDrawerList.setItemChecked(position, true);
            setTitle(navigationItems.get(position).getmTitle());

            mDrawerLayout.closeDrawers();
        }
    }

    @Override
    public void onClick(View v) {
        mActiveFragment.onClick(v);
    }
}
