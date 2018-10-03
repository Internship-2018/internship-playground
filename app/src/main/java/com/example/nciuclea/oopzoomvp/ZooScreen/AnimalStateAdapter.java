package com.example.nciuclea.oopzoomvp.ZooScreen;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStateModel;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStatePresenter;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStateView;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.State;
import com.example.nciuclea.oopzoomvp.Animal.DeadCallback;
import com.example.nciuclea.oopzoomvp.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalStateAdapter extends RecyclerView.Adapter<AnimalStateAdapter.AnimalViewHolder> implements AnimalStatePresenter {

    private DeadCallback deadCallback;
    private List<AnimalStateModel> animalStateModelList;

    AnimalStateAdapter(List<AnimalStateModel> animalStateModelList) {
        this.animalStateModelList = animalStateModelList;
    }

    @Override
    public void setDeadCallback(DeadCallback callback) {
        this.deadCallback = callback;
    }

    @Override
    public void onUpdateState() {
        for (AnimalStateModel model: animalStateModelList) {
            if (new Date()
                    .after(model.getTimeNewState()) &&  model.isMasterAlive()) {
                switch (model.getState()) {
                    case GREEN:
                        model.setState(State.YELLOW);
                        break;
                    case YELLOW:
                        model.setState(State.RED);
                        break;
                    case RED:
                        deadCallback.die();
                        break;
                }
                model.setTimeLastAction(new Date());
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public void onMasterDeath() {
        for (AnimalStateModel model: animalStateModelList) {
            model.setState(State.BLACK);
            model.setMasterIsDead();
        }
        notifyDataSetChanged();
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
    public void onBindViewHolder(@NonNull final AnimalStateAdapter.AnimalViewHolder animalViewHolder, final int i) {
        //filling UI elements
        final AnimalStateModel model = animalStateModelList.get(i);
        animalViewHolder.setStateName(model.getStateName());
        updateState(model.getState(), model, animalViewHolder);
        animalViewHolder.stateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (model.isMasterAlive()) {
                    updateState(State.GREEN, model, animalViewHolder);
                    model.setTimeLastAction(new Date());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalStateModelList.size();
    }

    void updateAnimalStatesList(List<AnimalStateModel> newAnimalStatesList) {
        if (animalStateModelList == null) animalStateModelList = new ArrayList<AnimalStateModel>(newAnimalStatesList);
        animalStateModelList.clear();
        animalStateModelList.addAll(newAnimalStatesList);
        notifyDataSetChanged();
    }

    private void updateState(State state, AnimalStateModel model, AnimalStateView view) {
        model.setState(state);
        String text = "UNDEFINED";
        int colorID = R.color.black;
        switch (state) {
            case GREEN:
                text = "GOOD";
                colorID = R.color.green;
                break;
            case YELLOW:
                text = "OK";
                colorID = R.color.yellow;
                break;
            case RED:
                text = "BAD";
                colorID = R.color.red;
                break;
            case BLACK:
                text = "DEAD";
                colorID = R.color.black;
                break;
        }
        view.updateButtonState(text, colorID);
    }
}
