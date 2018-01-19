package kamilmilik.przewodnikpogaleriihandlowej.MainView.parking;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import kamilmilik.przewodnikpogaleriihandlowej.MainView.shops.Identifiers;
import kamilmilik.przewodnikpogaleriihandlowej.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaveLocationsFragment extends Fragment {
    private static final String TAG = "SaveLocationsFragment";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private EditText editText;
    private Button saveLocationsButton;
    private SharedPreferencesOperation sharedPreferencesOperationForSaveLocations;
    private ArrayList<SavedDataObject> savedLocationsList;

    private ParkingSlideFragment parkingSlideFragment;
    public void setParkingSlideFragment(ParkingSlideFragment parkingSlideFragment) {
        this.parkingSlideFragment = parkingSlideFragment;
    }
    public SaveLocationsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save_locations, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        saveLocationsButton = view.findViewById(R.id.saveLocationButton);


        saveLocationsButtonAction(view);
        sharedPreferencesOperationForSaveLocations = new SharedPreferencesOperation(getActivity(), Identifiers.SHARED_PREFERENCES_SAVED_LOCATIONS_KEY);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view_save_locations);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }
    public void saveLocationsButtonAction(final View view){
        saveLocationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = view.findViewById(R.id.saveLocationsEditText);
                String positionAndLevelText = "";
                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                if(!editText.getText().toString().equals("")) {
                    positionAndLevelText = editText.getText().toString();
                    SavedDataObject savedDataObject = new SavedDataObject(currentDateTimeString, positionAndLevelText);
                    sharedPreferencesOperationForSaveLocations.saveToSharedPreferences(savedDataObject.getLevel(), savedDataObject);
                    savedLocationsList = sharedPreferencesOperationForSaveLocations.getAllItemsSavedFilter();
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private Activity activity;
        public MyAdapter(){
            savedLocationsList = sharedPreferencesOperationForSaveLocations.getAllItemsSavedFilter();
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_for_save_locations,parent,false);
            MyAdapter.ViewHolder viewHolder = new MyAdapter.ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            if(sharedPreferencesOperationForSaveLocations != null){
                savedLocationsList = sharedPreferencesOperationForSaveLocations.getAllItemsSavedFilter();
                SavedDataObject savedDataObject = savedLocationsList.get(position);
                setUpCardViewElements(holder,position,savedDataObject);

                clearImageAction(holder,savedDataObject);
                locationImageAction(holder,savedDataObject);
            }
        }
        public void setUpCardViewElements(MyAdapter.ViewHolder holder, int position,SavedDataObject savedDataObject){
            holder.text1.setText(savedDataObject.getCurrentDateTimeString());
            String positionAndLevelText = "";
            String level = savedDataObject.getLevel();
            if (Integer.valueOf(level) > 30) {
                positionAndLevelText = "#" + level+ " poziom(0)";
            } else {
                positionAndLevelText = "#" + level + " poziom(1)";
            }
            holder.text2.setText(positionAndLevelText);
        }
    public void clearImageAction(ViewHolder holder, final SavedDataObject savedDataObject){
            holder.clearImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPreferencesOperationForSaveLocations.deleteItem(savedDataObject.getLevel());
                    notifyDataSetChanged();
                }
            });
        }
        public void locationImageAction(ViewHolder holder, final SavedDataObject savedDataObject){
            holder.locationImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String levelString = savedDataObject.getLevel();
                    int level = -1;
                    if (Integer.valueOf(levelString) > 30) {
                        level = 0;
                    } else {
                        level = 1;
                    }
                    Log.i(TAG, level + " taki jest level");
                    parkingSlideFragment.setUpClickedButtonWhenUserClickMapInSaveLocations(level);
                    changeSlideView();
                }
            });
        }
        private void changeSlideView(){
            TabLayout tabhost = (TabLayout) getActivity().findViewById(R.id.tabs);
            tabhost.getTabAt(0).select();
        }
        @Override
        public int getItemCount() {
            savedLocationsList = sharedPreferencesOperationForSaveLocations.getAllItemsSavedFilter();
            if(savedLocationsList != null){
                return savedLocationsList.size();
            }else{
                return 0;
            }
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView clearImage,locationImage;
            private TextView text1,text2;
            public ViewHolder(View itemView) {
                super(itemView);
                text1 = itemView.findViewById(R.id.timeSaveLocationsText);
                text2 = itemView.findViewById(R.id.levelSaveLocationsText);
                clearImage = itemView.findViewById(R.id.clear);
                locationImage = itemView.findViewById(R.id.location);

            }

        }
    }
}
