package com.mtlepberghenov.internship_playground.ui.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.data.entites.sql.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class VehicleListAdapter extends RecyclerView.Adapter<VehicleListAdapter.MyViewHolder> {

  private List<Vehicle> vehicleList = new ArrayList<>();

  @NonNull
  @Override
  public VehicleListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

    View view = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_view, viewGroup, false);

    return new VehicleListAdapter.MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull VehicleListAdapter.MyViewHolder holder, int i) {
    holder.bindData(vehicleList.get(i));
  }

  @Override public int getItemCount() {
    return vehicleList.size();
  }

  public void setData(List<Vehicle> vehicleList) {
    this.vehicleList.clear();
    this.vehicleList.addAll(vehicleList);
    notifyDataSetChanged();
  }

  class MyViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_view_text_view) TextView textView;
    @BindString(R.string.item_text) String text;

    MyViewHolder(@NonNull View v) {
      super(v);
      ButterKnife.bind(this, v);
    }

    void bindData(Vehicle vehicle) {
      StringBuilder sb = new StringBuilder();

      /* Note: text = "Type: %s\nMake: %s\nModel: %s\nColor: %s\nYear: %s" */
      sb.append(String.format(text,
                                    vehicle.getType(),
                                    vehicle.getMake(),
                                    vehicle.getModel(),
                                    vehicle.getColor(),
                                    vehicle.getYear()));

      textView.setText(sb.toString());
      sb.setLength(0);
    }
  }
}
