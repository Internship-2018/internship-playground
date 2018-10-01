package com.example.nciuclea.oopzoomvp.ZooScreen;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nciuclea.oopzoomvp.Animal.Animal;
import com.example.nciuclea.oopzoomvp.R;

import java.util.ArrayList;
import java.util.List;

class ZooAdapter extends RecyclerView.Adapter<ZooAdapter.ZooViewHolder> {

    private List<Animal> animalList;
    private Runnable runnable;
    private Handler refreshHandler;

    public ZooAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public static class ZooViewHolder extends RecyclerView.ViewHolder {
        public TextView animalTextView;
        public ImageView animalImageView;
        public RecyclerView animalRecyclerView;
        AnimalAdapter animalAdapter;
        RecyclerView.LayoutManager animalLayoutManager;

        public ZooViewHolder(@NonNull View itemView) {
            super(itemView);
            animalTextView = itemView.findViewById(R.id.animalTextView);
            animalImageView = itemView.findViewById(R.id.animalImageView);
            animalRecyclerView = itemView.findViewById(R.id.animalRecyclerView);
            animalRecyclerView.setHasFixedSize(true);
            animalLayoutManager = new LinearLayoutManager(itemView.getContext());
            animalRecyclerView.setLayoutManager(animalLayoutManager);
            animalAdapter = new AnimalAdapter(null);
            animalRecyclerView.setAdapter(animalAdapter);
        }
    }

    @NonNull
    @Override
    public ZooViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View animalView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_animal, viewGroup, false);
        ZooViewHolder zooViewHolder = new ZooViewHolder(animalView);
        return zooViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ZooViewHolder zooViewHolder, int i) {
        zooViewHolder.animalTextView.setText(animalList.get(i).getType());
        zooViewHolder.animalImageView.setImageResource(animalList.get(i).getImageID());
        zooViewHolder.animalAdapter.updateAnimalStatesList(animalList.get(i).getStatesList());
        startRefreshing();
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public void updateAnimalList(List<Animal> newAnimalList) {
        if (animalList == null) animalList = new ArrayList<Animal>(newAnimalList);
        animalList.clear();
        animalList.addAll(newAnimalList);
        notifyDataSetChanged();
    }

    private void startRefreshing() {
        refreshHandler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (Animal animal: animalList) animal.updateStates();
                refreshHandler.postDelayed(this, 1000);
            }
        };
        refreshHandler.postDelayed(runnable, 1000);
    }
}
