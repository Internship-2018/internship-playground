package com.example.nciuclea.oopzoomvp.ui.allAnimals;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nciuclea.oopzoomvp.R;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;

import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.AnimalViewHolder>{

    private List<DBAnimal> animalsList;

    public AnimalsAdapter(List<DBAnimal> animalsList) {
        this.animalsList = animalsList;
    }

    @NonNull
    @Override
    public AnimalsAdapter.AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View animalView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_all_animals_animal, viewGroup, false);
        return new AnimalViewHolder(animalView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsAdapter.AnimalViewHolder animalViewHolder, int i) {
        animalViewHolder.updateItemUI(animalsList.get(i));
    }

    @Override
    public int getItemCount() {
        return animalsList.size();
    }

    public void updateData(List<DBAnimal> animalList) {
        this.animalsList.clear();
        this.animalsList.addAll(animalList);
        notifyDataSetChanged();
    }


    class AnimalViewHolder extends RecyclerView.ViewHolder {

        ImageView animalImageView;
        TextView animalTextView;
        Button animalOverallStateButton;

        AnimalViewHolder(@NonNull View itemView) {
            super(itemView);

            animalImageView = itemView.findViewById(R.id.animalImageView);
            animalTextView = itemView.findViewById(R.id.animalTextView);
            animalOverallStateButton = itemView.findViewById(R.id.overallStateButton);
        }

        void updateItemUI(DBAnimal animal) {
            animalTextView.setText(animal.getType());
            animalOverallStateButton.setText(animal.getOverallState().name());
        }
    }
}
