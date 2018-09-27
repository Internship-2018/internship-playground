package com.example.nciuclea.oopzoo;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalFragment extends Fragment {

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    private Animal animal;
    TextView animalNameTextView;
    ImageView animalImageView;
    private Runnable runnable;
    private Handler refreshHandler;
    private RecyclerView statusLineRecyclerView;
    private StatusLineAdapter statusLineAdapter;
    List<AnimalStatusLine> statusLineList;
    private RecyclerView.LayoutManager statusLineLayoutManager;

    boolean isPaused = false;

    public AnimalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal, container, false);
        //animal = new Tiger(3, 4);

        animalNameTextView = view.findViewById(R.id.animal_name);
        animalNameTextView.setText(animal.getType());

        animalImageView = view.findViewById(R.id.animal_image);
        animalImageView.setImageResource(getAnimalImage(animal.getType()));

        statusLineRecyclerView = view.findViewById(R.id.statusline_recyclerview);
        statusLineRecyclerView.setHasFixedSize(true);

        statusLineLayoutManager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically(){
                return false;
            }
        };
        statusLineRecyclerView.setLayoutManager(statusLineLayoutManager);
        statusLineList = animal.getStatusLineList();
        statusLineAdapter = new StatusLineAdapter(statusLineList);
        statusLineRecyclerView.requestDisallowInterceptTouchEvent(true);
        //fixing ACTION_UP miss
        statusLineRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                final int action = motionEvent.getAction();
                String DEBUG_TAG = "Recycler_ME";
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(DEBUG_TAG,"Action was DOWN");
                        return false;
                    case MotionEvent.ACTION_UP:
                        Log.d(DEBUG_TAG,"Action was UP");
                        animal.stopAllActivities();
                        return false;
                    default:
                        Log.d(DEBUG_TAG, String.valueOf(action));
                }
                Log.d("Recycler_ME", String.valueOf(motionEvent.getAction()));
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });


        statusLineRecyclerView.setAdapter(statusLineAdapter);
        setOnItemListener();


        refreshHandler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                //updating Tiger model
                animal.updateStats();
                //updating UI
                statusLineList.clear();
                statusLineList.addAll(animal.getStatusLineList());
                statusLineAdapter.notifyDataSetChanged();

                //scheduling next update
                if (!isPaused) refreshHandler.postDelayed(this, 100);
            }
        };
        refreshHandler.postDelayed(runnable, 100);

        return view;
    }

    private int getAnimalImage(String animalType) {
        switch (animalType) {
            case "Tiger":
                return getContext().getResources().getIdentifier("tiger", "drawable", getContext().getPackageName());
            case "Owl":
                return getContext().getResources().getIdentifier("owl", "drawable", getContext().getPackageName());
        }
        return 0;
    }

    @Override
    public void onPause() {
        super.onPause();
        isPaused = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        isPaused = false;
        refreshHandler.postDelayed(runnable, 1000);
    }

    public void setOnItemListener() {
        if (statusLineAdapter != null) {
            statusLineAdapter.setOnItemTouch(new StatusLineAdapter.OnItemTouchListener() {
                @Override
                public void onItemTouch(View view, int position, boolean type, String name) {
                    animal.updateActionStates(name, type);
                }
            });
        }
    }
    
}
