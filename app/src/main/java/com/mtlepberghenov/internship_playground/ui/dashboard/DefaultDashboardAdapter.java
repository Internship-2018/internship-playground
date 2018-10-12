package com.mtlepberghenov.internship_playground.ui.dashboard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class DefaultDashboardAdapter extends RecyclerView.Adapter<DefaultDashboardAdapter.ViewHolder>
    implements DashboardAdapter {

  @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    return null;
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

  }

  @Override public int getItemCount() {
    return 0;
  }

  @Override public void updateData(){}

  class ViewHolder extends RecyclerView.ViewHolder {

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
    }
  }
}
