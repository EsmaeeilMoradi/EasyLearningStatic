package com.esmaeeil_moradi.easy_learning_static;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    //Add a ShareActionProvider private variable.
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Attach the SectionsPagerAdapter to the ViewPager
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);
        //Attach the ViewPager to the TabLayout
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }

    //Implementing this method adds any items in the menu resource file to the app bar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        //Get a reference to the share action provider and assign it to the private variable
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        //call the setShareActionIntent()
        setShareActionIntent("Want to join me for pizza?");
        return super.onCreateOptionsMenu(menu);
    }

    //created the setShareActionIntent()
    private void setShareActionIntent(String text) {
        //creates an intent passes it to the share action provider
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        //This sets the default text in the share action provider
        shareActionProvider.setShareIntent(intent);
    }

    //This method gets called when an action on the app bar is clicked.
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                //Code to run when the Create Order item is clicked
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
                //Returning true tells Android you’ve dealt with the item being clicked
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //The FragmentPagerAdapter passes information to the ViewPager.
    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //Say how many pages the ViewPager should contain.
        @Override
        public int getCount() {
            return 4;
        }

        //Specify which fragment should appear on each page.
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TopFragment();
                case 1:
                    return new IntroChaptersFragment();
                case 2:
                    return new PastaFragment();
                case 3:
                    return new trainingAppFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.home_tab);
                case 1:
                    return getResources().getText(R.string.chapters_tab);
                case 2:
                    return getResources().getText(R.string.program_tab);
                case 3:
                    return getResources().getText(R.string.connect_tab);
            }
            return null;
        }
    }

}
