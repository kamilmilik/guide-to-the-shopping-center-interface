package kamilmilik.przewodnikpogaleriihandlowej.MainView.cinema;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import kamilmilik.przewodnikpogaleriihandlowej.MainView.shops.Identifiers;
import kamilmilik.przewodnikpogaleriihandlowej.R;

public class SelectedFilmActivity extends AppCompatActivity {
    private Button showMoreButton;
    private TextView selectedFilmDescribeText,selectedFilmText;
    private ImageView imageLogoSelectedFilm;
    private boolean expandable = true;
    private boolean expand = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_film);
        selectedFilmDescribeText = findViewById(R.id.describeShopText);
        imageLogoSelectedFilm = findViewById(R.id.imageLogoSelectedShop);
        selectedFilmText = findViewById(R.id.selectedFilmText);
        setUpToolbar();

        showMoreButton = findViewById(R.id.btShowmoreSelectedShopDescribe);

        showMoreOrLessTextAction();
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
}
