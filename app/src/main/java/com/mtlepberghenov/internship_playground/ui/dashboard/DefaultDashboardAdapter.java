package com.mtlepberghenov.internship_playground.ui.dashboard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import com.squareup.picasso.Picasso;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

public class DefaultDashboardAdapter
    extends RecyclerView.Adapter<DefaultDashboardAdapter.ViewHolder>
    implements DashboardAdapter {

  private List<Vehicle> list = new ArrayList<>();

  @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View v = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_recycler_view, viewGroup, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

    holder.bindData(list.get(i));
  }

  @Override public int getItemCount() {
    return list.size();
  }

  @Override public void updateData(List<Vehicle> list) {
    this.list.clear();
    this.list.addAll(list);
    notifyDataSetChanged();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_recycler_text_view) TextView textView;
    @BindView(R.id.item_recycler_image_view) ImageView imageView;

    ViewHolder(@NonNull View v) {
      super(v);
      ButterKnife.bind(this, v);
    }

    void bindData(Vehicle vehicle) {
      /* Note: ID: %s\nType: %s\nManufacturer: %s\nModel: %s\nColor: %s\nYear: %s */
      StringBuilder sb = new StringBuilder();
      String itemText = textView.getContext().getString(R.string.item_text);
      sb.append(String.format(itemText,
          vehicle.getIdString(),
          vehicle.getType(),
          vehicle.getManufacturer(),
          vehicle.getModel(),
          vehicle.getColor(),
          vehicle.getYear())
      );

      textView.setText(sb.toString());
      sb.delete(0, sb.length());

      Timber.d(vehicle.getImageUrl());
      Picasso.get()
          .load(vehicle.getImageUrl())
          .error(R.drawable.no_image)
          .into(imageView);
    }
  }
}
