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
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class DefaultDashboardAdapter
    extends RecyclerView.Adapter<DefaultDashboardAdapter.ViewHolder>
    implements DashboardAdapter {

  private List<Vehicle> list = new ArrayList<>();

  // FIXME: Delete when will be api
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
    // FIXME: change to list.get(i) when will be api
    holder.bindData(testArray[i]);
  }

  @Override public int getItemCount() {
    // FIXME: Change to list.size() when will be api
    return testArray.length;
  }

  @Override public void updateData(List<Vehicle> list) {
    this.list.clear();
    this.list.addAll(list);
    notifyDataSetChanged();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_recycler_view) TextView textView;

    ViewHolder(@NonNull View v) {
      super(v);
      ButterKnife.bind(this, v);
    }

    void bindData(String s) {
      // FIXME: change when will be api
      textView.setText(s);
    }
  }
}
