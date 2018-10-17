package com.example.nciuclea.oopzoomvp.ui.animaldescription.impl;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nciuclea.oopzoomvp.R;
import com.example.nciuclea.oopzoomvp.storage.dao.Zoopark;

import java.util.ArrayList;
import java.util.List;

public class ZooAdapter extends Adapter<ZooAdapter.ZooViewHolder> {

    private List<Zoopark> zooList;

    public ZooAdapter(List<Zoopark> zooList) {
        this.zooList = zooList;
    }

    @NonNull
    @Override
    public ZooAdapter.ZooViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View zooView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_zoo, viewGroup, false);
        return new ZooViewHolder(zooView);
    }

    @Override
    public void onBindViewHolder(@NonNull ZooAdapter.ZooViewHolder zooViewHolder, int i) {
        zooViewHolder.updateItemUI(zooList.get(i));
    }

    @Override
    public int getItemCount() {
        return zooList.size();
    }

    public void updateData(List<Zoopark> zooList){
        this.zooList = new ArrayList<>(zooList);
        notifyDataSetChanged();
    }

    class ZooViewHolder extends RecyclerView.ViewHolder {

        TextView zooName;
        TextView zooCity;
        TextView zooAddress;

        public ZooViewHolder(@NonNull View itemView) {
            super(itemView);
            zooName = itemView.findViewById(R.id.zooName_recyclerView);
            zooCity = itemView.findViewById(R.id.zooCity_recyclerView);
            zooAddress = itemView.findViewById(R.id.zooAddress_recyclerView);
        }

        void updateItemUI(Zoopark zoo) {
            zooName.setText(zoo.getZooName());
            zooCity.setText(zoo.getCity());
            zooAddress.setText(zoo.getAddress());
        }
    }
}
