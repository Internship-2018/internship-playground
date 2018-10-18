package com.mtlepberghenov.internship_playground.ui.dashboard;

import android.support.annotation.StringRes;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;

public interface DashboardView {

  void setRefreshHandler(DashboardRefreshHandler refreshHandler);

  void setAdapter(DashboardAdapter adapter);

  void updateData(List<Vehicle> list);

  void showMessage(@StringRes int stringRes);

  void setRefreshingFalse();
}
