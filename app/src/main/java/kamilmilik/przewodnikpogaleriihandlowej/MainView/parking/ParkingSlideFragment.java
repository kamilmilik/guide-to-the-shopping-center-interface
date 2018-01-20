package kamilmilik.przewodnikpogaleriihandlowej.MainView.parking;


import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import kamilmilik.przewodnikpogaleriihandlowej.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParkingSlideFragment extends Fragment {
    private static final String TAG = "ParkingSlideFragment";
    private ColorStateList oldColors;
    private Button button1,button2;
    private FrameLayout frameParking;

    public ParkingSlideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parking_slide, container, false);


    }

    public void setUpClickedButtonWhenUserClickMapInSaveLocations(int numberOfLevel) {
        Log.i(TAG, "setUpCLickedButton " + numberOfLevel);
        if (numberOfLevel == 0) {
            clickedButton1();
        } else {
            clickedButton2();
        }
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button1 = view.findViewById(R.id.btn1GalleryPlan);
        button2 = view.findViewById(R.id.btn2GalleryPlan);
        frameParking = view.findViewById(R.id.frameParking);
        oldColors =  button2.getTextColors();//get default text color in button

        button1Action();
        button2Action();
    }
    public void button1Action(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedButton1();
            }
        });
    }
    public void clickedButton1(){
                button1.setBackgroundColor(getResources().getColor(R.color.grey));
                button1.setTextColor(getResources().getColor(R.color.darkPink));
                button2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                button2.setTextColor(oldColors);
                frameParking.setBackground(getResources().getDrawable(R.drawable.plan_parkingu));
    }
    public void clickedButton2(){
                button2.setBackgroundColor(getResources().getColor(R.color.grey));
                button2.setTextColor(getResources().getColor(R.color.darkPink));
                button1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                button1.setTextColor(oldColors);
                frameParking.setBackground(getResources().getDrawable(R.drawable.plan_parkingu2));

    }
    public void button2Action(){
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedButton2();
            }
        });
    }
}
