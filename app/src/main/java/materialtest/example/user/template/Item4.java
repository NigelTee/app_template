package materialtest.example.user.template;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Item4 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item4);

        //initialize toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.item4_toolbar);
        setSupportActionBar(toolbar);

        //initialize actionbar
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            setSupportActionBar(toolbar); //activate custom action bar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//show home button
        }
        getSupportActionBar().setHomeButtonEnabled(true);//enable home button on top left corner
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Navigation Drawer
        mDrawerLayout = (DrawerLayout) this.findViewById(R.id.drawer_layout);
        NavigationView mDrawer = (NavigationView) findViewById(R.id.item4_drawer);
        //TextView username = (TextView) findViewById(R.id.header_username);
        //TextView userEmail = (TextView) findViewById(R.id.header_email);
        mDrawer.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
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

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Intent intent;
        if (menuItem.getItemId() == R.id.navigation_item_1) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
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
