package com.example.nciuclea.oopzoomvp.ZooScreen;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nciuclea.oopzoomvp.Animal.ActionText;
import com.example.nciuclea.oopzoomvp.Animal.Animal;
import com.example.nciuclea.oopzoomvp.R;

import java.util.ArrayList;
import java.util.List;

class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ZooViewHolder> {

    private List<Animal> animalList;
    private Runnable runnable;
    private Handler refreshHandler;

    public AnimalAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public static class ZooViewHolder extends RecyclerView.ViewHolder {
        public TextView animalTextView;
        public ImageView animalImageView;
        public RecyclerView animalRecyclerView;
        public Button actionButton;
        AnimalStateAdapter animalStateAdapter;
        RecyclerView.LayoutManager animalLayoutManager;

        public ZooViewHolder(@NonNull View itemView) {
            super(itemView);
            animalTextView = itemView.findViewById(R.id.animalTextView);
            animalImageView = itemView.findViewById(R.id.animalImageView);
            actionButton = itemView.findViewById(R.id.actionButton);
            animalRecyclerView = itemView.findViewById(R.id.animalRecyclerView);
            animalRecyclerView.setHasFixedSize(true);
            animalLayoutManager = new LinearLayoutManager(itemView.getContext());
            animalRecyclerView.setLayoutManager(animalLayoutManager);
            animalStateAdapter = new AnimalStateAdapter(null);
            animalRecyclerView.setAdapter(animalStateAdapter);
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
    public void onBindViewHolder(@NonNull final ZooViewHolder zooViewHolder, final int i) {
        zooViewHolder.animalTextView.setText(animalList.get(i).getType());
        zooViewHolder.animalImageView.setImageResource(animalList.get(i).getImageID());
        if (animalList.get(i) instanceof ActionText) {
            zooViewHolder.actionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (animalList.get(i).isAlive()) {
                        Toast toast = Toast.makeText(zooViewHolder.itemView.getContext(),
                                ((ActionText) animalList.get(i)).getActionText(),
                                Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            });
        } else {
            zooViewHolder.actionButton.setVisibility(View.GONE);
        }
        zooViewHolder.animalStateAdapter.updateAnimalStatesList(animalList.get(i).getStatesList());
        zooViewHolder.animalStateAdapter.setDeadCallback(animalList.get(i));
        animalList.get(i).setPresenter(zooViewHolder.animalStateAdapter);
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
        if (refreshHandler != null) refreshHandler.removeCallbacksAndMessages(null);
        refreshHandler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (Animal animal : animalList) {
                    if (animal.isAlive()) {
                        animal.updateStates();
                    } else {
                        startFuneral();
                    }
                }
                refreshHandler.postDelayed(this, 1000);
            }
        };
        refreshHandler.postDelayed(runnable, 1000);
    }

    private void startFuneral() {
        //to implement after refactoring to MVP
    }
}
