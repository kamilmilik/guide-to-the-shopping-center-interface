package kamilmilik.przewodnikpogaleriihandlowej.MainView.accesandcontact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import kamilmilik.przewodnikpogaleriihandlowej.R;

public class AccessAndContactActivity extends AppCompatActivity {
    private static final int ACTIVITY_NUM = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_and_contact);
        setUpToolbar();


        BottomNavigation bottomNavigation = new BottomNavigation(this, getApplicationContext());
        bottomNavigation.setWhichActivityRun(0);
        bottomNavigation.bottomNavigationAction();
        bottomNavigation.setUpSwitchedOptionInBottomNavigation(ACTIVITY_NUM);

        AccessFragment accessFragment = new AccessFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutForFragments,accessFragment);
        fragmentTransaction.commit();

    }
    public void setUpToolbar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
