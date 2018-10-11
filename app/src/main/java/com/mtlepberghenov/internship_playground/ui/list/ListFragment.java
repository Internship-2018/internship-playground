package com.mtlepberghenov.internship_playground.ui.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import com.mtlepberghenov.internship_playground.ui.list.impl.DefaultListModel;
import com.mtlepberghenov.internship_playground.ui.list.impl.DefaultListPresenter;
import com.mtlepberghenov.internship_playground.ui.list.impl.DefaultListView;
import com.mtlepberghenov.internship_playground.ui.list.loader.DbDataLoader;
import com.mtlepberghenov.internship_playground.ui.list.loader.impl.DefaultDbLoaderCallback;
import java.util.List;

public class ListFragment extends Fragment {

  public static final int LOADER_ID = 100;
  private ListNativeView listNativeView;
  private ListPresenter listPresenter;
  private LoaderManager.LoaderCallbacks<List<SqlVehicle>> loaderCallbacks;
  private ListModel listModel;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final DefaultListView view = new DefaultListView();
    final DbDataLoader dbDataLoader = new DbDataLoader(getContext());
    final DefaultListModel model = new DefaultListModel(dbDataLoader);
    listModel = model;
    loaderCallbacks = new DefaultDbLoaderCallback(dbDataLoader, model);
    listNativeView = view;
    listPresenter = new DefaultListPresenter(view, model);
    LoaderManager.getInstance(this).initLoader(LOADER_ID, null, loaderCallbacks);
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
