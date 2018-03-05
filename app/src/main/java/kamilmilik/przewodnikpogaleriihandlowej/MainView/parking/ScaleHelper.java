package kamilmilik.przewodnikpogaleriihandlowej.MainView.parking;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.Random;

/**
 * Created by kamil on 05.03.2018.
 */

public class ScaleHelper {
    private final String TAG = ScaleHelper.class.getName();
    public static  float createRandomScale(PhotoView photoView){
        Random r = new Random();
        float minScale = photoView.getMinimumScale();
        float maxScale = photoView.getMaximumScale();
        float randomScale = minScale + (r.nextFloat() * (maxScale - minScale));
        return  randomScale;
    }
    public static int createXScale(Activity activity){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int centerX=width/2;
        return  centerX;
    }
    public static int createYScale(Activity activity){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int centerY =height/2;
        return centerY;
    }
}
