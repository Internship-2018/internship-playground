package com.mtlepberghenov.internship_playground.ui.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mtlepberghenov.internship_playground.ui.list.impl.DefaultListModel;
import com.mtlepberghenov.internship_playground.ui.list.impl.DefaultListPresenter;
import com.mtlepberghenov.internship_playground.ui.list.impl.DefaultListView;

public class ListFragment extends Fragment {

  private ListNativeView listNativeView;
  private ListPresenter listPresenter;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    DefaultListView view = new DefaultListView();
    listNativeView = view;
    listPresenter = new DefaultListPresenter(view, new DefaultListModel());
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(listNativeView.getLayout(), container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    listNativeView.initView(getActivity());
    listPresenter.onViewInitialised();
  }
}
