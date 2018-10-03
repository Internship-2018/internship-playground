package com.example.nciuclea.oopzoomvp.ZooScreen;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStatePresenter;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStateView;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.State;
import com.example.nciuclea.oopzoomvp.R;

import java.util.ArrayList;
import java.util.List;

public class AnimalStateAdapter extends RecyclerView.Adapter<AnimalStateAdapter.AnimalViewHolder> {

    private List<AnimalStatePresenter> animalStatesList;

    AnimalStateAdapter(List<AnimalStatePresenter> animalStatesList) {
        this.animalStatesList = animalStatesList;
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
        public void updateButtonState(String text, int colorID) {
            stateButton.setText(text);
            stateButton.setTextColor(ContextCompat.getColor(itemView.getContext(), colorID));
        }
    }

    @NonNull
    @Override
    public AnimalStateAdapter.AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View stateView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_state, viewGroup, false);
        return new AnimalViewHolder(stateView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalStateAdapter.AnimalViewHolder animalViewHolder, final int i) {
        animalStatesList.get(i).setView(animalViewHolder); //setting view to presenter
        animalStatesList.get(i).onInitUI(); //filling UI elements
        animalViewHolder.stateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animalStatesList.get(i).onTakeAction();
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalStatesList.size();
    }

    void updateAnimalStatesList(List<AnimalStatePresenter> newAnimalStatesList) {
        if (animalStatesList == null) animalStatesList = new ArrayList<AnimalStatePresenter>(newAnimalStatesList);
        animalStatesList.clear();
        animalStatesList.addAll(newAnimalStatesList);
        notifyDataSetChanged();
    }
}
