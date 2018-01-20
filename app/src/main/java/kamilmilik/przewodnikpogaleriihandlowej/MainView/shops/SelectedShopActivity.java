package kamilmilik.przewodnikpogaleriihandlowej.MainView.shops;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kamilmilik.przewodnikpogaleriihandlowej.R;

public class SelectedShopActivity extends AppCompatActivity {
    private static final String TAG = "SelectedShopActivity";
    private Button showMoreButton;
    private TextView selectedShopDescribeText, selectedShopLevelText, showInMapText;
    private ImageView promotionImage, imageLogoSelectedShops;
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
        promotionImage = findViewById(R.id.promotionImage);
        showInMapText = findViewById(R.id.textContact2);
        imageLogoSelectedShops = findViewById(R.id.imageLogoSelectedShop);

        String selectedShop = getIntent().getStringExtra(Identifiers.SHOP_NAME_KEY);
        String selectedShopLevel = getIntent().getStringExtra(Identifiers.SHOP_LEVEL_KEY);
        int selectedImage = getIntent().getIntExtra(Identifiers.SHOP_IMAGE_KEY, 0);

        imageLogoSelectedShops.setBackgroundResource(selectedImage);
        selectedShopLevelText.setText(selectedShopLevel);
        selectedShopDescribeText.setText(selectedShop + " " +selectedShop + " " +selectedShop + " " +selectedShop + " " +selectedShop + " " + "Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy Dummy dummy ");
        showMoreOrLessTextAction();
        promotionImageAction();
        showInMapAction();
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
    public void promotionImageAction(){
        promotionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Tutaj musze isc do nowego activity w klasie SelectedShopActivity",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showInMapAction(){
        showInMapText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Tutaj musze isc do nowego activity w klasie SelectedShopActivity",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
