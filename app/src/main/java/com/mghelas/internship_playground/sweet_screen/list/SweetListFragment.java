package com.mghelas.internship_playground.sweet_screen.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mghelas.internship_playground.datasource.DbHelper;
import com.mghelas.internship_playground.sweet_screen.list.impl.SweetListModelImpl;
import com.mghelas.internship_playground.sweet_screen.list.impl.SweetListPresenterImpl;
import com.mghelas.internship_playground.sweet_screen.list.impl.SweetListViewImpl;
import com.mghelas.internship_playground.sweet_screen.list.impl.SweetListWireframeImpl;

public class SweetListFragment extends Fragment {

    DbHelper sweetReaderDbHelper;
    SweetListNativeView sweetListNativeView;
    SweetListPresenter sweetListPresenter;
    SweetListWireframe sweetListWireframe;
    SweetListModel sweetListModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SweetListViewImpl view = new SweetListViewImpl();
        sweetReaderDbHelper = new DbHelper(getContext());
        sweetListModel = new SweetListModelImpl(sweetReaderDbHelper);
        sweetListWireframe = new SweetListWireframeImpl(this);
        sweetListNativeView = view;
        sweetListPresenter = new SweetListPresenterImpl(view, sweetListWireframe, sweetListModel);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(sweetListNativeView.getLayout(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sweetListNativeView.initView(this, sweetListPresenter);
        sweetListPresenter.onViewInitialised();
    }

}
