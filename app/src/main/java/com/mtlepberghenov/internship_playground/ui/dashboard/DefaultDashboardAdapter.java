package com.mtlepberghenov.internship_playground.ui.dashboard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mtlepberghenov.internship_playground.R;

public class DefaultDashboardAdapter extends RecyclerView.Adapter<DefaultDashboardAdapter.ViewHolder>
    implements DashboardAdapter {

  private String[] testArray = {
      "Hello",
      "Hello",
      "Hello",
      "Hello",
      "Hello",
      "Hello",
  };

  @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View v = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_recycler_view, viewGroup, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
    holder.bindData(testArray[i]);
  }

  @Override public int getItemCount() {
    return testArray.length;
  }

  @Override public void updateData(){}

  static class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_recycler_view) TextView textView;

    ViewHolder(@NonNull View v) {
      super(v);
      ButterKnife.bind(this, v);
    }

    void bindData(String s) {
      textView.setText(s);
    }
  }
}
