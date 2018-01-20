package kamilmilik.przewodnikpogaleriihandlowej.MainView.cinema;

import android.animation.ObjectAnimator;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

import kamilmilik.przewodnikpogaleriihandlowej.MainView.shops.Identifiers;
import kamilmilik.przewodnikpogaleriihandlowej.R;

public class SelectedFilmActivity extends AppCompatActivity {
    private static final String TAG = "SelectedFilmActivity";
    private Button showMoreButton, showDateButton, buyTicketButton;
    private TextView selectedFilmDescribeText,selectedFilmText, chooseDateText;
    private ImageView imageLogoSelectedFilm;
    private boolean expandable = true;
    private boolean expand = false;
    private int mYear,mMonth,mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_film);
        selectedFilmDescribeText = findViewById(R.id.describeShopText);
        imageLogoSelectedFilm = findViewById(R.id.imageLogoSelectedShop);
        selectedFilmText = findViewById(R.id.selectedFilmText);
        showDateButton = findViewById(R.id.chooseDateSelectedFilmButton);
        showMoreButton = findViewById(R.id.btShowmoreSelectedShopDescribe);
        chooseDateText = findViewById(R.id.chooseDateText);
        buyTicketButton = findViewById(R.id.buyTicketButton);

        setUpToolbar();

        chooseDateButtonAction();

        showMoreOrLessTextAction();

        buyTicketButtonAction();

        String selectedFilm = getIntent().getStringExtra(Identifiers.FILM_NAME_KEY);
        String selectedTextLevel = getIntent().getStringExtra(Identifiers.FILM_TEXT_LEVEL_KEY);
        int selectedImage = getIntent().getIntExtra(Identifiers.FILM_IMAGE_KEY, 0);

        selectedFilmText.setText(selectedFilm);
        imageLogoSelectedFilm.setBackgroundResource(selectedImage);
        selectedFilmDescribeText.setText(selectedFilm + " " +selectedFilm + " " +selectedFilm + " " +selectedFilm + " " +selectedFilm + " " + "Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy ");

    }
    public void setUpToolbar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    public void showMoreOrLessTextAction(){
        selectedFilmDescribeText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(expandable) {
                    expandable = false;
                    if (selectedFilmDescribeText.getLineCount() > 4) {
                        showMoreButton.setVisibility(View.VISIBLE);
                        ObjectAnimator animation = ObjectAnimator.ofInt(selectedFilmDescribeText, "maxLines", 4);
                        animation.setDuration(0).start();
                    }
                }
            }
        });
        showMoreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!expand) {
                    expand = true;
                    ObjectAnimator animation = ObjectAnimator.ofInt(selectedFilmDescribeText, "maxLines", 40);
                    animation.setDuration(100).start();
                    showMoreButton.setText("Mniej");
                } else {
                    expand = false;
                    ObjectAnimator animation = ObjectAnimator.ofInt(selectedFilmDescribeText, "maxLines", 4);
                    animation.setDuration(100).start();
                    showMoreButton.setText("Więcej");
                }
            }
        });
    }
    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            Log.i(TAG,mYear+"/" + mMonth + "/" + mDay);
            chooseDateText.setText(mYear+"/" + mMonth+1 + "/" + mDay);
        }
    };
    public void chooseDateButtonAction(){
        showDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = getResources().getConfiguration().locale;
                Locale.setDefault(locale);
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dateDialog =  new DatePickerDialog(SelectedFilmActivity.this, datePickerListener, year, month, day);
                dateDialog.show();
            }
        });
    }
    public void buyTicketButtonAction(){
        buyTicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BuyTicketActivity.class);
                startActivity(intent);
            }
        });
    }
}
