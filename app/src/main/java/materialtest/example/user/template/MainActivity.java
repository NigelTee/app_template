package materialtest.example.user.template;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import materialtest.Fragments.Fragment1;
import materialtest.Fragments.Fragment2;
import materialtest.Fragments.Fragment3;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(toolbar);

        //initialize actionbar
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            setSupportActionBar(toolbar); //activate custom action bar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//show home button
        }
        getSupportActionBar().setHomeButtonEnabled(true);//enable home button on top left corner
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //initialize FAB
        FloatingActionButton mFAB = (FloatingActionButton) findViewById(R.id.fab);
        mFAB.setOnClickListener(mFabClickListener);

        //initialize ViewPager
        final ViewPager viewPager = (ViewPager) findViewById(R.id.main_activity_viewpager);
        setupViewPager(viewPager);

        //Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_activity_tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        showToast("One");
                        break;
                    case 1:
                        showToast("Two");

                        break;
                    case 2:
                        showToast("Three");

                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Navigation Drawer
        mDrawerLayout = (DrawerLayout) this.findViewById(R.id.drawer_layout);
        NavigationView mDrawer = (NavigationView) findViewById(R.id.mainActivity_drawer);
        //TextView username = (TextView) findViewById(R.id.header_username);
        //TextView userEmail = (TextView) findViewById(R.id.header_email);
        mDrawer.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //FAB
    private View.OnClickListener mFabClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            showToast("FAB");
            Intent intent = new Intent(MainActivity.this, FAB.class);
            startActivity(intent);
        }
    };

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Fragment1(), "FRAG1");
        adapter.addFrag(new Fragment2(), "FRAG2");
        adapter.addFrag(new Fragment3(), "FRAG3");
        //adapter.addFrag(new DummyFragment(getResources().getColor(R.color.button_material_dark)), "MOUSE");
        viewPager.setAdapter(adapter);
    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    //Navigation Drawer Item List
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Intent intent;
        if (menuItem.getItemId() == R.id.navigation_item_1) {
            return true;
        }
        if (menuItem.getItemId() == R.id.navigation_item_2) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Item2.class);
            startActivity(intent);
            return true;
        }
        if (menuItem.getItemId() == R.id.navigation_item_3) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Item3.class);
            startActivity(intent);
            return true;
        }
        if (menuItem.getItemId() == R.id.navigation_item_4) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Item4.class);
            startActivity(intent);
            return true;
        }
        if (menuItem.getItemId() == R.id.navigation_item_5) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Item5.class);
            startActivity(intent);
            return true;
        }

        return false;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }
}
