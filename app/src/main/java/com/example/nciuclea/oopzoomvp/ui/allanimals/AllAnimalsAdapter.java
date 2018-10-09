package com.example.nciuclea.oopzoomvp.ui.allanimals;

import android.content.Context;
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

public class AllAnimalsAdapter extends RecyclerView.Adapter<AllAnimalsAdapter.AnimalViewHolder>{

    private Context context;
    private List<DBAnimal> animalsList;
    private AllAnimalsClickHandler clickHandler;

    public AllAnimalsAdapter(Context context, List<DBAnimal> animalsList) {
        this.context = context;
        this.animalsList = animalsList;
    }

    @NonNull
    @Override
    public AllAnimalsAdapter.AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View animalView = LayoutInflater.from(viewGroup.getContext())
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

    public void updateData(List<DBAnimal> animalList) {
        this.animalsList.clear();
        //BAM
        this.animalsList.addAll(animalList);
        notifyDataSetChanged();
    }

    public void setClickHandler(AllAnimalsClickHandler clickHandler) {
        this.clickHandler = clickHandler;
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
            animalOverallStateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickHandler.onClick(v, animalsList.get(getAdapterPosition()).getId());
                }
            });
        }

        void updateItemUI(DBAnimal animal) {
            animalTextView.setText(animal.getType());
            animalOverallStateButton.setText(animal.getOverallState().getText());
            animalOverallStateButton.setTextColor(context.getResources()
                    .getColor(animal.getOverallState().getColor()));
            animalImageView.setImageDrawable(context.getResources()
                    .getDrawable(animal.getImageID()));
        }
    }
}
