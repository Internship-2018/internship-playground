package com.mtlepberghenov.internship_playground.screens.welcome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.screens.main.presenter.MainPresenter;
import com.mtlepberghenov.internship_playground.screens.main.presenter.MainPresenterIml;
import com.mtlepberghenov.internship_playground.screens.main.view.MainView;

public class WelcomeFragment extends Fragment implements MainView {

  private MainPresenter mainPresenter;

  private NavController navController;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mainPresenter = new MainPresenterIml();
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_welocme, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    ButterKnife.bind(this, view);
    mainPresenter.attach(this);
  }

  @Override public void onStartScreen() {
    if (getActivity() != null) {
      navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
      navController.navigate(R.id.vehicleListFragment);
    }
  }

  @OnClick(R.id.show_store_btn) public void onClick() {
    mainPresenter.onClicked();
  }
}
