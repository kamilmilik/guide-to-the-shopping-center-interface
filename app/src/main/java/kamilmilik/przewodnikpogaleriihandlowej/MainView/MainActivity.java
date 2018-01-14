package kamilmilik.przewodnikpogaleriihandlowej.MainView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import kamilmilik.przewodnikpogaleriihandlowej.MainView.accesandcontact.AccessAndContactActivity;
import kamilmilik.przewodnikpogaleriihandlowej.MainView.login.LoginActivity;
import kamilmilik.przewodnikpogaleriihandlowej.R;

public class MainActivity extends AppCompatActivity {
   private ImageView cardImage1,cardImage2,cardImage3,imageLogo;
   private TextView cardText1,cardText2,cardText3;
   private LinearLayout verticalLinear1,verticalLinear2,verticalLinear3,verticalLinear4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();

        findViewByIdAllWidgets();
        setUpWidgets();

        imageLogoAction();
        informationCardAction();
    }
    public void setUpToolbar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }
    public void findViewByIdAllWidgets(){
        cardImage1 = findViewById(R.id.imageCardView1);
        cardImage2 = findViewById(R.id.imageCardView2);
        cardImage3 = findViewById(R.id.imageCardView3);
        cardText1 = findViewById(R.id.textCardView1);
        cardText2 = findViewById(R.id.textCardView2);
        cardText3 = findViewById(R.id.textCardView3);

        verticalLinear1 = findViewById(R.id.verticalLinear1);
        verticalLinear2 = findViewById(R.id.verticalLinear2);
        verticalLinear3 = findViewById(R.id.verticalLinear3);
        verticalLinear4 = findViewById(R.id.verticalLinear4);

        imageLogo = findViewById(R.id.imageLogo);

    }
    public void setUpWidgets(){
        setUpCardHorizontalWidgets();
    }
    public void setUpCardHorizontalWidgets(){
        String[] labelsArray = {"Sklepy","Parking", "Kino"};
        int[] imagesArray = {R.drawable.gal, R.drawable.gal2,R.drawable.gal1};
        cardImage1.setBackgroundResource(imagesArray[0]);
        cardImage2.setBackgroundResource(imagesArray[1]);
        cardImage3.setBackgroundResource(imagesArray[2]);
        cardText1.setText(labelsArray[0]);
        cardText2.setText(labelsArray[1]);
        cardText3.setText(labelsArray[2]);
    }
    public void imageLogoAction(){
        imageLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AccessAndContactActivity.class);
                startActivity(intent);
            }
        });
    }
    public void informationCardAction(){
        verticalLinear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AccessAndContactActivity.class);
                startActivity(intent);
            }
        });
    }
    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.accountMenu:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
