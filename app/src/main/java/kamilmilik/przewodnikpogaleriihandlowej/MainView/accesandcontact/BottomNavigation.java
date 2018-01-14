package kamilmilik.przewodnikpogaleriihandlowej.MainView.accesandcontact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;


import kamilmilik.przewodnikpogaleriihandlowej.R;

/**
 * Created by kamil on 14.01.2018.
 */

class BottomNavigation  {
    private Activity activity;
    private Context context;


    private BottomNavigationView bottomNavigationView;
    public BottomNavigationView getBottomNavigationView() {
        return bottomNavigationView;
    }
    public BottomNavigation(Activity activity, Context context){
        this.activity = activity;
        this.context = context;
    }
    private int whichActivityRun;
    public void setWhichActivityRun(int value){
        this.whichActivityRun = value;
    }
    public void bottomNavigationAction() {
        bottomNavigationView = (BottomNavigationView)
                activity.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_bus:
                                AccessFragment accessFragment = new AccessFragment();
                                android.support.v4.app.FragmentTransaction fragmentTransaction =((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.frameLayoutForFragments,accessFragment);
                                fragmentTransaction.commit();
//                                        Intent intentAccess = new Intent(activity.getApplicationContext(), AccessAndContactActivity.class);
//                                        activity.startActivity(intentAccess);
                                break;
                            case R.id.action_call:
                                ContactFragment contactFragment = new ContactFragment();
                                android.support.v4.app.FragmentTransaction fragmentTransaction2 =((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
                                fragmentTransaction2.replace(R.id.frameLayoutForFragments,contactFragment);
                                fragmentTransaction2.commit();
                                //FragmentManager manager = activity.getFragmentManager();
                               // manager.beginTransaction().replace(R.id.ac, new Fragment1()).commit();

//                                Intent intentContact = new Intent(context, ContactActivity.class);
//                                intentContact.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                context.startActivity(intentContact);
                                break;
                        }
                        return true;
                    }
                });
    }

    public void setUpSwitchedOptionInBottomNavigation(int ACTIVITY_NUM){
        Menu menu = getBottomNavigationView().getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


}
