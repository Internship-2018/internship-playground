package com.mtlepberghenov.internship_playground.ui.welcome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mtlepberghenov.internship_playground.ui.welcome.impl.DefaultWelcomeModel;
import com.mtlepberghenov.internship_playground.ui.welcome.impl.DefaultWelcomePresenter;
import com.mtlepberghenov.internship_playground.ui.welcome.impl.DefaultWelcomeView;
import com.mtlepberghenov.internship_playground.ui.welcome.impl.DefaultWelcomeWireFrame;

public class WelcomeFragment extends Fragment {

  private WelcomeNativeView welcomeNativeView;
  private WelcomePresenter welcomePresenter;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DefaultWelcomeView view = new DefaultWelcomeView();
    welcomeNativeView = view;
    welcomePresenter = new DefaultWelcomePresenter(view, new DefaultWelcomeModel(),
        new DefaultWelcomeWireFrame(getActivity()));
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(welcomeNativeView.getLayout(), container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    welcomeNativeView.initView(view);
    welcomePresenter.onViewInitialised();
  }
}
