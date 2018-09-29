package com.mtlepberghenov.internship_playground.screens.carlist.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.model.entity.Car;

import com.mtlepberghenov.internship_playground.model.entity.Vehicle;
import java.util.ArrayList;

public class VehicleListAdapter extends RecyclerView.Adapter<VehicleListAdapter.MyViewHolder>{

  private ArrayList<Vehicle> vehicleList = new ArrayList<>();

  @NonNull
  @Override
  public VehicleListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

    View view = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_view, viewGroup, false);

    return new VehicleListAdapter.MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull VehicleListAdapter.MyViewHolder holder, int i) {
    holder.textView.setText("");
  }

  @Override
  public int getItemCount() {
    return vehicleList.size();
  }

  public void setData(ArrayList<Vehicle> vehicleList) {
    this.vehicleList.clear();
    this.vehicleList.addAll(vehicleList);
    notifyDataSetChanged();
  }


  public static class MyViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.item_view_text_view) TextView textView;

    public MyViewHolder(@NonNull View v) {
      super(v);

      ButterKnife.bind(this, v);

    }
  }
}
