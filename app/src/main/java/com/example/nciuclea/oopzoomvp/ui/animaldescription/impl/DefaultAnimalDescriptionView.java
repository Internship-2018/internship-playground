package com.example.nciuclea.oopzoomvp.ui.animaldescription.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class DefaultAnimalDescriptionView implements AnimalDescriptionView, AnimalDescriptionNativeView {

    private Context context;

    private TextView nameTextView;
    private ImageView animalImageView;
    boolean isImageFitToScreen;
    private TextView habitatTextView;
    private TextView locationTextView;
    private TextView descriptionTextView;

    private RecyclerView zooRecyclerView;
    private RecyclerView.LayoutManager zooLayoutManager;
    private ZooAdapter zooAdapter;

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;



    public DefaultAnimalDescriptionView(Context context) { this.context = context; }

    @Override
    public int getLayout() { return R.layout.fragment_animal_description; }

    @Override
    public void initView(View view) {
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

        toolbar = view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout = view.findViewById(R.id.collapsing_toolbar_layout);

    }

    @Override
    public void setOnClickHandler(AnimalDescriptionClickHandler animalDescriptionClickHandler) {

    }

    @Override
    public void updateUI(Animal animal) {

        toolbar.setTitle(animal.getName());
        toolbar.setTitleTextColor(context.getResources().getColor(R.color.black));
        Picasso.get()
                .load(animal.getImageUrl())
                .resize(800, 800)
                .centerInside()
                .into(new Target() {
                                                          @Override
                                                          public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                                              animalImageView.setImageBitmap(bitmap);
                                                              Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, 1, 1, true);
                                                              final int color = bitmap1.getPixel(0,0);
                                                              bitmap1.recycle();
                                                              collapsingToolbarLayout.setBackgroundColor(color);
                                                              collapsingToolbarLayout.setContentScrimColor(color);
                                                          }

                                                          @Override
                                                          public void onBitmapFailed(Exception e, Drawable errorDrawable) {

                                                          }

                                                          @Override
                                                          public void onPrepareLoad(Drawable placeHolderDrawable) {

                                                          }
                                                      });
                habitatTextView.setText(animal.getHabitat());
        locationTextView.setText(animal.getLocation());
        descriptionTextView.setText(animal.getDescription());
        zooAdapter.updateData(animal.getZooList());


    }
}
