package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nciuclea.oopzoomvp.R;
import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsClickHandler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AllAnimalsAdapter extends RecyclerView.Adapter<AllAnimalsAdapter.AnimalViewHolder>{

    private Context context;
    private List<Animal> animalsList;
    private AllAnimalsClickHandler clickHandler;

    public AllAnimalsAdapter(Context context, List<Animal> animalsList) {
        this.context = context;
        this.animalsList = animalsList;
    }

    @NonNull
    @Override
    public AllAnimalsAdapter.AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View animalView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_all_animals_animal, viewGroup, false);
        return new AnimalViewHolder(animalView);
    }

    @Override
    public void onBindViewHolder(@NonNull AllAnimalsAdapter.AnimalViewHolder animalViewHolder, int i) {
        animalViewHolder.updateItemUI(animalsList.get(i));
    }

    @Override
    public int getItemCount() {
        return animalsList.size();
    }

    public void updateData(List<Animal> animalList) {
        this.animalsList = new ArrayList<>(animalList);
        notifyDataSetChanged();
    }

    public void setClickHandler(AllAnimalsClickHandler clickHandler) {
        this.clickHandler = clickHandler;
    }


    class AnimalViewHolder extends RecyclerView.ViewHolder {

        ImageView animalImageView;
        TextView animalTextView;

        AnimalViewHolder(@NonNull final View itemView) {
            super(itemView);
            animalImageView = itemView.findViewById(R.id.allanimals_animalImageView);
            animalTextView = itemView.findViewById(R.id.allanimals_animalNameTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickHandler.onClick(itemView, animalsList.get(getLayoutPosition()).getId());
                }
            });

        }

        void updateItemUI(Animal animal) {
            Picasso.get().load(animal.getImageUrl()).into(animalImageView);
            animalTextView.setText(animal.getName());
        }
    }
}
