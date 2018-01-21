package kamilmilik.przewodnikpogaleriihandlowej.MainView.shops;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import kamilmilik.przewodnikpogaleriihandlowej.MainView.login.LoginActivity;
import kamilmilik.przewodnikpogaleriihandlowej.R;

public class ShopsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private  String[] labelsArray1,labelsArray2;
    private int[] imagesArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);

        setUpToolbar();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        labelsArray1 = new String[]{"4f", "5asec", "ALDO", "Apart", "Benneton", "Bershka", "BIG STAR", "C&A", "Dr Max", "Online"};
        labelsArray2 = new String[]{"0, #121", "1, #1234", "-1, #123425", "1, #1765", "1, #354", "1, #12341", "1, #1221", "1, #1261", "1, #1218", "1, #1921"};
        imagesArray = new int[]{R.drawable.four4f, R.drawable.five5asec, R.drawable.aldo, R.drawable.apart, R.drawable.benneton, R.drawable.bershka, R.drawable.bigstar, R.drawable.ca, R.drawable.a1635, R.drawable.online};
        mAdapter = new MyAdapter(labelsArray1,labelsArray2,imagesArray);
        mRecyclerView.setAdapter(mAdapter);

    }
    public void setUpToolbar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    //menu
    private Menu optionsMenu;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_check_box, menu);

        optionsMenu = menu;
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.checkable_item_1:
                if(item.isChecked()){
                    makeDefaultStateOfRecyclerViewItems();
                    item.setChecked(false);
                }
                else {
                    labelsArray1 = new String[]{"4f", "Benneton","Bershka", "BIG STAR", "C&A"};
                    labelsArray2 = new String[]{"0, #121","1, #354", "1, #354", "1, #12341", "1, #1221", "1, #1261"};
                    imagesArray = new int[]{R.drawable.four4f,R.drawable.benneton, R.drawable.bershka, R.drawable.bigstar, R.drawable.ca};
                    mAdapter = new MyAdapter(labelsArray1,labelsArray2,imagesArray);
                    mRecyclerView.setAdapter(mAdapter);
                    item.setChecked(true);
                }
                optionsMenu.findItem(R.id.checkable_item_2).setChecked(false);
                optionsMenu.findItem(R.id.checkable_item_3).setChecked(false);
                optionsMenu.findItem(R.id.checkable_item_4).setChecked(false);
                return true;
            case R.id.checkable_item_2:
                if(item.isChecked()){
                    makeDefaultStateOfRecyclerViewItems();
                    item.setChecked(false);
                }
                else {
                    labelsArray1 = new String[]{"5asec"};
                    labelsArray2 = new String[]{"1, #1234"};
                    imagesArray = new int[]{R.drawable.five5asec};
                    mAdapter = new MyAdapter(labelsArray1,labelsArray2,imagesArray);
                    mRecyclerView.setAdapter(mAdapter);
                    item.setChecked(true);
                }
                optionsMenu.findItem(R.id.checkable_item_1).setChecked(false);
                optionsMenu.findItem(R.id.checkable_item_3).setChecked(false);
                optionsMenu.findItem(R.id.checkable_item_4).setChecked(false);
                return true;
            case R.id.checkable_item_3:
                if(item.isChecked()){
                    makeDefaultStateOfRecyclerViewItems();
                    item.setChecked(false);
                }
                else {
                    labelsArray1 = new String[]{"Aldo"};
                    labelsArray2 = new String[]{"-1, #123425"};
                    imagesArray = new int[]{R.drawable.aldo};
                    mAdapter = new MyAdapter(labelsArray1,labelsArray2,imagesArray);
                    mRecyclerView.setAdapter(mAdapter);
                    item.setChecked(true);
                }
                optionsMenu.findItem(R.id.checkable_item_1).setChecked(false);
                optionsMenu.findItem(R.id.checkable_item_2).setChecked(false);
                optionsMenu.findItem(R.id.checkable_item_4).setChecked(false);
                return true;
            case R.id.checkable_item_4:
                if(item.isChecked()){
                    makeDefaultStateOfRecyclerViewItems();
                    item.setChecked(false);
                }
                else {
                    labelsArray1 = new String[]{"Dr Max"};
                    labelsArray2 = new String[]{"1, #1921"};
                    imagesArray = new int[]{R.drawable.a1635};
                    mAdapter = new MyAdapter(labelsArray1,labelsArray2,imagesArray);
                    mRecyclerView.setAdapter(mAdapter);
                    item.setChecked(true);
                }
                optionsMenu.findItem(R.id.checkable_item_1).setChecked(false);
                optionsMenu.findItem(R.id.checkable_item_2).setChecked(false);
                optionsMenu.findItem(R.id.checkable_item_3).setChecked(false);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
    public void makeDefaultStateOfRecyclerViewItems(){
        labelsArray1 = new String[]{"4f", "5asec", "ALDO", "Apart", "Benneton", "Bershka", "BIG STAR", "C&A", "Dr Max", "Online"};
        labelsArray2 = new String[]{"0, #121", "1, #1234", "-1, #123425", "1, #1765", "1, #354", "1, #12341", "1, #1221", "1, #1261", "1, #1218", "1, #1921"};
        imagesArray = new int[]{R.drawable.four4f, R.drawable.five5asec, R.drawable.aldo, R.drawable.apart, R.drawable.benneton, R.drawable.bershka, R.drawable.bigstar, R.drawable.ca, R.drawable.a1635, R.drawable.online};
        mAdapter = new MyAdapter(labelsArray1,labelsArray2,imagesArray);
        mRecyclerView.setAdapter(mAdapter);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private String[] labelTextArray1;
        private String[] labelTextArray2;
        private int[] imagesArray;

        public MyAdapter(String[] labelTextArray1,String[] labelTextArray2, int[] imagesArray){
            this.labelTextArray1 = labelTextArray1;
            this.labelTextArray2 = labelTextArray2;
            this.imagesArray = imagesArray;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shops_card_view,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            setUpCardViewElements(holder,position);
            clickToCardAction(holder,position);
        }
        public void setUpCardViewElements(ViewHolder holder, int position){
            holder.image.setBackgroundResource(imagesArray[position]);
            holder.text1.setText(labelTextArray1[position]);
            holder.text2.setText("Poziom" + labelTextArray2[position]);
        }
        private void clickToCardAction(final ViewHolder holder, final int position) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),SelectedShopActivity.class);
                    intent.putExtra(Identifiers.SHOP_IMAGE_KEY, imagesArray[position]);
                    intent.putExtra(Identifiers.SHOP_NAME_KEY, labelTextArray1[position]);
                    intent.putExtra(Identifiers.SHOP_LEVEL_KEY, labelTextArray2[position]);
                    startActivity(intent);
                }
            });
        }
        @Override
        public int getItemCount() {
            return imagesArray.length;
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text1,text2;
        private ImageView image;
            public ViewHolder(View itemView) {
                super(itemView);
                text1 = itemView.findViewById(R.id.textShopsCardView1);
                text2 = itemView.findViewById(R.id.textShopsCardView2);
                image = itemView.findViewById(R.id.imageShopsCardView1);

            }

        }
    }

}
