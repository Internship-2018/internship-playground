package com.example.nciuclea.oopzoo;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TigerFragment extends Fragment {

    Tiger tiger;
    Runnable runnable;
    Handler refreshHandler;
    RatingBar hungerRatingBar, cageRatingBar;
    Button feedButton, cageButton;
    boolean isPaused = false;

    public TigerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal, container, false);

        FrameLayout animalStatusLayout = view.findViewById(R.id.animal_status_layout);
        LayoutInflater statusInflater = LayoutInflater.from(getActivity());
        View statusView = statusInflater.inflate(R.layout.partial_tiger_status, animalStatusLayout, false);
        animalStatusLayout.addView(statusView);

        TextView animalNameTextView = view.findViewById(R.id.animal_name);
        hungerRatingBar = view.findViewById(R.id.hunger_rating_bar);
        cageRatingBar = view.findViewById(R.id.cage_rating_bar);
        feedButton = view.findViewById(R.id.feed_button);
        cageButton = view.findViewById(R.id.cage_button);



        tiger = new Tiger(1, 4);
        hungerRatingBar.setRating(tiger.getHungerLevel());

        refreshHandler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                //updating Tiger model and RatingBars on UI
                tiger.updateStats();
                hungerRatingBar.setRating(tiger.getHungerLevel());
                cageRatingBar.setRating(tiger.getCageCleanLevel());

                //scheduling next update
                if (!isPaused) refreshHandler.postDelayed(this, 100);
            }
        };
        refreshHandler.postDelayed(runnable, 100);

        feedButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        tiger.setFed(true);
                        return true;
                    case MotionEvent.ACTION_UP:
                        tiger.setFed(false);
                        return true;
                }
                return false;
            }
        });

        cageButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        tiger.setCageCleaned(true);
                        return true;
                    case MotionEvent.ACTION_UP:
                        tiger.setCageCleaned(false);
                        return true;
                }
                return false;
            }
        });

        return view;
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

}
