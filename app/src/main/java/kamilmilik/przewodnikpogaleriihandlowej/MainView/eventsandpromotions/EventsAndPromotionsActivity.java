package kamilmilik.przewodnikpogaleriihandlowej.MainView.eventsandpromotions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kamilmilik.przewodnikpogaleriihandlowej.MainView.shops.Identifiers;
import kamilmilik.przewodnikpogaleriihandlowej.MainView.shops.SelectedShopActivity;
import kamilmilik.przewodnikpogaleriihandlowej.R;

public class EventsAndPromotionsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_and_promotions);

        setUpToolbar();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        String[] labelsArray1 = {"W 4F WŁAŚNIE RUSZYŁA ZIMOWA PROMOCJA","WYPRZEDAŻ W SKLEPIE ALDO","ZIMOWA WYPRZEDAŻ -50% NA WSZYSTKO!"};
        String[] labelsArray2 = {"0, #121","1, #1765","1, #354","1, #12341"};
        int[] imagesArray = {R.drawable.four4f,R.drawable.aldo,R.drawable.apart};
        mAdapter = new MyAdapter(labelsArray1,labelsArray2,imagesArray);
        mRecyclerView.setAdapter(mAdapter);
    }
    public void setUpToolbar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_promotions_and_events,parent,false);
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
            private TextView text1;
            private ImageView image;
            public ViewHolder(View itemView) {
                super(itemView);
                text1 = itemView.findViewById(R.id.titleShopEvent);
                image = itemView.findViewById(R.id.imagesShopEvent);

            }

        }
    }
}
