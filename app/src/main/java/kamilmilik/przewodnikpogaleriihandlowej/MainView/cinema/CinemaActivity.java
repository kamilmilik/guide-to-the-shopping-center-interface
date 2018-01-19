package kamilmilik.przewodnikpogaleriihandlowej.MainView.cinema;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import kamilmilik.przewodnikpogaleriihandlowej.MainView.parking.ParkingActivity;
import kamilmilik.przewodnikpogaleriihandlowej.MainView.parking.ParkingSlideFragment;
import kamilmilik.przewodnikpogaleriihandlowej.MainView.parking.SaveLocationsFragment;
import kamilmilik.przewodnikpogaleriihandlowej.R;

public class CinemaActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);

        setUpToolbar();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }
    public void setUpToolbar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            switch (position){
                case 0:
                    TodayFilmsFragment todayFilmsFragment = new TodayFilmsFragment();
                    return todayFilmsFragment;
                case 1:
                    TomorrowFilmsFragment tomorrowFilmsFragment = new TomorrowFilmsFragment();
                    return tomorrowFilmsFragment;
                case 2:
                    AnotherDateFilmsFragment anotherDateFilmsFragment = new AnotherDateFilmsFragment();
                    return anotherDateFilmsFragment;
                default:
                    return null;
            }
        }


        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "FIRST";
                case 1:
                    return "SECOND";
                case 2:
                    return "THIRD";
            }
            return  null;
        }
    }
}
