package kamilmilik.przewodnikpogaleriihandlowej.MainView.parking;

/**
 * Created by kamil on 19.01.2018.
 */

public class SavedDataObject {
    public SavedDataObject(String currentDateTimeString,String level){
        this.currentDateTimeString = currentDateTimeString;
        this.level = level;
    }
    private String currentDateTimeString;
    private String level;
    public String getCurrentDateTimeString() {
        return currentDateTimeString;
    }

    public String getLevel() {
        return level;
    }

}
