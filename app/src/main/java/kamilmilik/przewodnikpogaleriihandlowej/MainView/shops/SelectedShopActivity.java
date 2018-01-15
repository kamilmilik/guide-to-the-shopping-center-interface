package kamilmilik.przewodnikpogaleriihandlowej.MainView.shops;

import android.animation.ObjectAnimator;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;

import kamilmilik.przewodnikpogaleriihandlowej.R;

public class SelectedShopActivity extends AppCompatActivity {
    private static final String TAG = "SelectedShopActivity";
private Button showMoreButton;
private TextView selectedShopDescribeText,selectedShopLevelText;
       private boolean expandable = true;
        private boolean expand = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_shop);
        setUpToolbar();

        showMoreButton = findViewById(R.id.btShowmoreSelectedShopDescribe);
        selectedShopDescribeText = findViewById(R.id.describeShopText);
        selectedShopLevelText = findViewById(R.id.selectedShopLevel);

        String selectedShop = getIntent().getStringExtra(Identifiers.SHOP_NAME_KEY);
        String selectedShopLevel = getIntent().getStringExtra(Identifiers.SHOP_LEVEL_KEY);
        selectedShopLevelText.setText(selectedShopLevel);
        selectedShopDescribeText.setText(selectedShop + " " +selectedShop + " " +selectedShop + " " +selectedShop + " " +selectedShop + " " + "Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy ");
        showMoreOrLessTextAction();
    }
    public void showMoreOrLessTextAction(){
        selectedShopDescribeText.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(expandable) {
                    expandable = false;
                    if (selectedShopDescribeText.getLineCount() > 4) {
                        showMoreButton.setVisibility(View.VISIBLE);
                        ObjectAnimator animation = ObjectAnimator.ofInt(selectedShopDescribeText, "maxLines", 4);
                        animation.setDuration(0).start();
                    }
                }
            }
        });
        showMoreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!expand) {
                    expand = true;
                    ObjectAnimator animation = ObjectAnimator.ofInt(selectedShopDescribeText, "maxLines", 40);
                    animation.setDuration(100).start();
                    showMoreButton.setText("Mniej");
                } else {
                    expand = false;
                    ObjectAnimator animation = ObjectAnimator.ofInt(selectedShopDescribeText, "maxLines", 4);
                    animation.setDuration(100).start();
                    showMoreButton.setText("Więcej");
                }
            }
        });
    }
    public void setUpToolbar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
