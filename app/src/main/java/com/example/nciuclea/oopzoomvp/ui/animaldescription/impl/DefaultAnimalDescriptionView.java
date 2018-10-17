package com.example.nciuclea.oopzoomvp.ui.animaldescription.impl;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nciuclea.oopzoomvp.R;
import com.example.nciuclea.oopzoomvp.storage.dao.Animal;
import com.example.nciuclea.oopzoomvp.storage.dao.Zoopark;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.AnimalDescriptionClickHandler;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.AnimalDescriptionNativeView;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.AnimalDescriptionView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DefaultAnimalDescriptionView implements AnimalDescriptionView, AnimalDescriptionNativeView {

    private Context context;

    private TextView nameTextView;
    private ImageView animalImageView;
    private TextView habitatTextView;
    private TextView locationTextView;
    private TextView descriptionTextView;

    private RecyclerView zooRecyclerView;
    private RecyclerView.LayoutManager zooLayoutManager;
    private ZooAdapter zooAdapter;



    public DefaultAnimalDescriptionView(Context context) { this.context = context; }

    @Override
    public int getLayout() { return R.layout.fragment_animal_description; }

    @Override
    public void initView(View view) {
        nameTextView = view.findViewById(R.id.animalNameTextView);
        animalImageView = view.findViewById(R.id.animalImageView);
        habitatTextView = view.findViewById(R.id.habitatTextView);
        locationTextView = view.findViewById(R.id.locationTextView);
        descriptionTextView = view.findViewById(R.id.descriptionTextView);

        zooRecyclerView = view.findViewById(R.id.zoosRecyclerView);
        zooRecyclerView.setHasFixedSize(true);
        zooLayoutManager = new LinearLayoutManager(view.getContext());
        zooRecyclerView.setLayoutManager(zooLayoutManager);
        zooAdapter = new ZooAdapter(new ArrayList<Zoopark>());
        zooRecyclerView.setAdapter(zooAdapter);

    }

    @Override
    public void setOnClickHandler(AnimalDescriptionClickHandler animalDescriptionClickHandler) {

    }

    @Override
    public void updateUI(Animal animal) {
        Picasso.get().load(animal.getImageUrl()).into(animalImageView);
        nameTextView.setText(animal.getName());
        habitatTextView.setText(animal.getHabitat());
        locationTextView.setText(animal.getLocation());
        descriptionTextView.setText(animal.getDescription());
        zooAdapter.updateData(animal.getZooList());
    }
}
