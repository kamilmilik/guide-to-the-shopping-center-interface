package kamilmilik.przewodnikpogaleriihandlowej.MainView.parking;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kamilmilik.przewodnikpogaleriihandlowej.MainView.login.UserDataObject;
import kamilmilik.przewodnikpogaleriihandlowej.MainView.shops.Identifiers;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by kamil on 19.01.2018.
 */


public class SharedPreferencesOperation {
    private static final String TAG = "SharedPreferences";
    private SharedPreferences sharedPreferences;
    private Activity activity;

    public SharedPreferencesOperation(Activity activity, String key) {
        this.activity = activity;
        sharedPreferences =  this.activity.getSharedPreferences(key,(MODE_PRIVATE));;
    }
    public void saveToSharedPreferences(String key ,Object object){
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(object);
        prefsEditor.putString(key, json);
        prefsEditor.commit();
        Log.i(TAG,json.toString());
    }
    public void deleteItem(String key){
        sharedPreferences.edit().remove(key).commit();
    }
    public void deleteAll(){
        sharedPreferences.edit().clear().commit();
    }

    public SavedDataObject getItemSavedFilter(String key){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(key, "");
        SavedDataObject obj = gson.fromJson(json, SavedDataObject.class);
        return obj;
    }
    public ArrayList<SavedDataObject> getAllItemsSavedFilter(){
        Gson gson = new Gson();
        ArrayList<SavedDataObject> mapOfObj = new ArrayList<>();
        Map<String, ?> allEntries = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            if(entry.getValue() != null){
                SavedDataObject obj = gson.fromJson(entry.getValue().toString(), SavedDataObject.class);
                //Log.d("map values", entry.getKey() + ": " + obj.getCurrentDateTimeString() + " "+ obj.getLevel());
                mapOfObj.add(obj);
            }
        }
        return mapOfObj;
    }
    public ArrayList<UserDataObject> getAllItemsLogin(){
        Gson gson = new Gson();
        ArrayList<UserDataObject> mapOfObj = new ArrayList<>();
        Map<String, ?> allEntries = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            if(entry.getValue() != null){
                UserDataObject obj = gson.fromJson(entry.getValue().toString(), UserDataObject.class);
                //Log.d("map values", entry.getKey() + ": " + obj.getCurrentDateTimeString() + " "+ obj.getLevel());
                mapOfObj.add(obj);
            }
        }
        return mapOfObj;
    }
//    public void putInt( int value){
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt(Identifiers.SHARED_PREFERENCES_SAVED_LOCATIONS_FOR_PARKING_FRAGMENT_KEY, value);
//        //Log.i(TAG,"put int " + value);
//        editor.apply();
//    }
//    public int getInt(String key){
//        int data = sharedPreferences.getInt(key, -1);
//        return  data;
//    }

}
