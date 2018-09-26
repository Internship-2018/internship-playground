package com.example.nciuclea.oopzoo;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TigerFragment extends Fragment {

    Tiger tiger;

    public TigerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal, container, false);
        TextView animalNameTextView = view.findViewById(R.id.animal_name);
        final RatingBar hungerRatingBar = view.findViewById(R.id.hungerRatingBar);
        Button feedButton = view.findViewById(R.id.feed_button);
        tiger = new Tiger(5, 4);
        hungerRatingBar.setRating(tiger.getHungerLevel());

        final Handler refreshHandler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //updating Tiger model and RatingBars on UI
                tiger.updateHunger();
                hungerRatingBar.setRating(tiger.getHungerLevel());
                //scheduling next update
                refreshHandler.postDelayed(this, 100);
            }
        };
        refreshHandler.postDelayed(runnable, 100);

        feedButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        tiger.startFeeding();
                        return true;
                    case MotionEvent.ACTION_UP:
                        tiger.stopFeeding();
                        return true;
                }
                return false;
            }
        });

        return view;
    }

}
