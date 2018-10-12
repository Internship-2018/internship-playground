package com.mtlepberghenov.internship_playground.ui.dashboard;

import com.mtlepberghenov.internship_playground.storage.model.Data;
import java.util.List;

public interface DashboardView {

  void setAdapter(DashboardAdapter adapter);

  void updateData(List<Data> list);
}
