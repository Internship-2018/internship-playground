package com.mghelas.internship_playground.ui.sweetscreen.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.storage.entity.Sweet;

import java.util.List;

public class SweetAdapter extends RecyclerView.Adapter<SweetAdapter.MyViewHolder> {


    private List<Sweet> items;
    private ItemClickHandler itemClickHandler;

    private List<Sweet> getItems() {
        return items;
    }

    public SweetAdapter(List<Sweet> items, ItemClickHandler itemClickHandler) {
        this.items = items;
        this.itemClickHandler = itemClickHandler;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sweet_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView price;
        TextView weight;

        MyViewHolder(View view) {
            super(view);
            title = itemView.findViewById(R.id.titleDetailed);
            price = itemView.findViewById(R.id.priceDetailed);
            weight = itemView.findViewById(R.id.weightDetailed);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickHandler.onItemClicked(getItems().get(getLayoutPosition()).getId());
                }
            });
        }

        void bindData(Sweet sweet) {
            title.setText(sweet.getTitle());
            price.setText(sweet.getPrice() + "");
            weight.setText(sweet.getWeight() + "");
        }
    }
}
