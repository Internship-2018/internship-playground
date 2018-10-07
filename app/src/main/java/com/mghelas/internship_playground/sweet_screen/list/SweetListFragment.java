package com.mghelas.internship_playground.sweet_screen.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweet_screen.list.impl.SweetListModelImpl;
import com.mghelas.internship_playground.sweet_screen.list.impl.SweetListPresenterImpl;
import com.mghelas.internship_playground.sweet_screen.list.impl.SweetListViewImpl;
import com.mghelas.internship_playground.sweet_screen.list.impl.SweetListWireframeImpl;

import java.util.ArrayList;
import java.util.List;

public class SweetListFragment extends Fragment {

    SweetListNativeView sweetListNativeView;
    SweetListPresenter sweetListPresenter;
    SweetListWireframe sweetListWireframe;
    SweetListModel sweetListModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SweetListViewImpl view = new SweetListViewImpl();
        sweetListModel = new SweetListModelImpl();
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
