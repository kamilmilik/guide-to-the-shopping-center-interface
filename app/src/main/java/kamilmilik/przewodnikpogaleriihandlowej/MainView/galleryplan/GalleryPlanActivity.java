package kamilmilik.przewodnikpogaleriihandlowej.MainView.galleryplan;

import android.content.res.ColorStateList;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.Random;

import kamilmilik.przewodnikpogaleriihandlowej.MainView.parking.ScaleHelper;
import kamilmilik.przewodnikpogaleriihandlowej.MainView.shops.Identifiers;
import kamilmilik.przewodnikpogaleriihandlowej.R;

public class GalleryPlanActivity extends AppCompatActivity {
    private static final String TAG = "GalleryPlanActivity";
    private Button buttonLevel1, buttonLevel2, buttonLevel3;
    private ColorStateList oldColors;
    //private ConstraintLayout constraintLayout;
    private PhotoView photoView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_plan);
        buttonLevel1 = findViewById(R.id.btn1GalleryPlan);
        buttonLevel2 = findViewById(R.id.btn2GalleryPlan);
        buttonLevel3 = findViewById(R.id.btn3GalleryPlan);
        photoView = (PhotoView) findViewById(R.id.photo_view_gallery_plan);
        setScaleToPhoto(photoView);
        photoView.setImageResource(R.drawable.plan_parkingu);
        //constraintLayout = findViewById(R.id.constraintGalleryPlan);

        oldColors =  buttonLevel2.getTextColors();//get default text color in button
        setUpToolbar();

        buttonLevel1Action();
        buttonLeve12Action();
        buttonLevel3Action();

        String level = getIntent().getStringExtra(Identifiers.LEVEL_FROM_SELECTED_SHOP_TO_GALLERY_PLAN_KEY);
        if(level != null){
            int levelInt = Integer.valueOf(level);
            Log.i(TAG, levelInt + " poziom");
            if(levelInt == -1){
                clickedButton1();
            }else if(levelInt == 0){
                clickedButton2();
            }else if(levelInt == 1){
                clickedButton3();
            }
        }

    }
    public void setUpToolbar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    public void buttonLevel1Action(){
        buttonLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedButton1();
            }
        });
    }
    public void buttonLeve12Action(){
        buttonLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedButton2();
            }
        });
    }
    public void buttonLevel3Action(){
        buttonLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedButton3();
            }
        });
    }
    public void clickedButton1(){
        buttonLevel1.setBackgroundColor(getResources().getColor(R.color.grey));
        buttonLevel1.setTextColor(getResources().getColor(R.color.darkPink));
        buttonLevel2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        buttonLevel2.setTextColor(oldColors);
        buttonLevel3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        buttonLevel3.setTextColor(oldColors);
        setScaleToPhoto(photoView);
        photoView.setImageResource(R.drawable.plan_parkingu);
        //constraintLayout.setBackground(getResources().getDrawable(R.drawable.plan_parkingu));
    }
    public void clickedButton2(){
        buttonLevel2.setBackgroundColor(getResources().getColor(R.color.grey));
        buttonLevel2.setTextColor(getResources().getColor(R.color.darkPink));
        buttonLevel1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        buttonLevel1.setTextColor(oldColors);
        buttonLevel3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        buttonLevel3.setTextColor(oldColors);
        setScaleToPhoto(photoView);
        photoView.setImageResource(R.drawable.poziom0);
        //constraintLayout.setBackground(getResources().getDrawable(R.drawable.poziom0));
    }
    public void clickedButton3(){
        buttonLevel3.setBackgroundColor(getResources().getColor(R.color.grey));
        buttonLevel3.setTextColor(getResources().getColor(R.color.darkPink));
        buttonLevel1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        buttonLevel1.setTextColor(oldColors);
        buttonLevel2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        buttonLevel2.setTextColor(oldColors);

        setScaleToPhoto(photoView);
        photoView.setImageResource(R.drawable.plan_parkingu2);
        //constraintLayout.setBackground(getResources().getDrawable(R.drawable.plan_parkingu2));
    }
    private void setScaleToPhoto(PhotoView photoView){
        float randomScale = ScaleHelper.createRandomScale(photoView);
        int centerX=ScaleHelper.createXScale(this);
        int centerY =ScaleHelper.createYScale(this);
        photoView.setScale(randomScale, centerX, centerY, true);
    }
}
