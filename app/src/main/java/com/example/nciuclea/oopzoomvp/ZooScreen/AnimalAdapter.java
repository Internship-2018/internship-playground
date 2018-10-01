package com.example.nciuclea.oopzoomvp.ZooScreen;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStatePresenterImpl;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStateView;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.State;
import com.example.nciuclea.oopzoomvp.R;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private List<AnimalStatePresenterImpl> statesList;

    public AnimalAdapter(List<AnimalStatePresenterImpl> statesList) {
        this.statesList = statesList;
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder implements AnimalStateView {
        public TextView stateTextView;
        public Button stateButton;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            stateTextView = itemView.findViewById(R.id.stateTextView);
            stateButton = itemView.findViewById(R.id.stateButton);
        }

        @Override
        public void setStateName(String name) {
            stateTextView.setText(name);
        }

        @Override
        public void updateStateButton(State state) {
            changeStateButtonName(state);
            changeStateButtonColor(state);
        }

        @Override
        public void changeStateButtonName(State state) {
            String text = "UNDEFINED";
            switch (state) {
                case GREEN:
                    text = "GOOD";
                    break;
                case YELLOW:
                    text = "OK";
                    break;
                case RED:
                    text = "BAD";
                    break;
                case BLACK:
                    text = "DEAD";
                    break;
            }
            stateButton.setText(text);
        }

        @Override
        public void changeStateButtonColor(State state) {
            int colorID = R.color.black;
            switch (state) {
                case GREEN:
                    colorID = R.color.green;
                    break;
                case YELLOW:
                    colorID = R.color.yellow;
                    break;
                case RED:
                    colorID = R.color.red;
                    break;
                case BLACK:
                    colorID = R.color.black;
                    break;
            }
            stateButton.setTextColor(ContextCompat.getColor(itemView.getContext(), colorID));
        }
    }

    @NonNull
    @Override
    public AnimalAdapter.AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View stateView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_state, viewGroup, false);
        AnimalViewHolder animalViewHolder = new AnimalViewHolder(stateView);
        return animalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.AnimalViewHolder animalViewHolder, final int i) {
        statesList.get(i).setView(animalViewHolder);
        statesList.get(i).initUI();
        animalViewHolder.stateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statesList.get(i).takeAction();
            }
        });
    }

    @Override
    public int getItemCount() {
        return statesList.size();
    }

    public void updateAnimalStatesList(List<AnimalStatePresenterImpl> newAnimalStatesList) {
        if (statesList == null) statesList = new ArrayList<AnimalStatePresenterImpl>(newAnimalStatesList);
        statesList.clear();
        statesList.addAll(newAnimalStatesList);
        notifyDataSetChanged();
    }
}
