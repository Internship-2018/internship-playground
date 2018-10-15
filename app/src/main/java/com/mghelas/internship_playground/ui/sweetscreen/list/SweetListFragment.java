package com.mghelas.internship_playground.ui.sweetscreen.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mghelas.internship_playground.network.sweet.SweetServiceCall;
import com.mghelas.internship_playground.network.sweet.SweetServiceCallImpl;
import com.mghelas.internship_playground.storage.dao.impl.SweetDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.list.impl.DbListLoaderCallbackImpl;
import com.mghelas.internship_playground.ui.sweetscreen.list.impl.SweetListModelImpl;
import com.mghelas.internship_playground.ui.sweetscreen.list.impl.SweetListPresenterImpl;
import com.mghelas.internship_playground.ui.sweetscreen.list.impl.SweetListViewImpl;
import com.mghelas.internship_playground.ui.sweetscreen.list.impl.SweetListWireframeImpl;
import com.mghelas.internship_playground.ui.sweetscreen.list.loader.DbListLoader;

import java.util.List;

public class SweetListFragment extends Fragment {

    private static final int LOADER_ID = 1000;

    SweetListNativeView sweetListNativeView;
    SweetListPresenter sweetListPresenter;
    SweetListWireframe sweetListWireframe;
    SweetListModelImpl sweetListModel;
    SweetListCallback sweetListCallback;
    DbHelper dbHelper;
    SweetDao sweetDao;
    SweetServiceCall sweetServiceCall;
    protected LoaderManager.LoaderCallbacks<List<Sweet>> listLoaderCallbacks;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = DbHelper.getInstance(getContext());
        sweetDao = new SweetDaoImpl(dbHelper);
        final SweetListViewImpl view = new SweetListViewImpl();
        final DbListLoader dbDataLoader = new DbListLoader(getContext(), sweetDao);
        sweetListModel = new SweetListModelImpl(dbDataLoader);
        sweetListWireframe = new SweetListWireframeImpl(this);
        sweetListPresenter = new SweetListPresenterImpl(view, sweetListWireframe, sweetListModel);
        sweetListCallback = sweetListPresenter;
        sweetListNativeView = view;
        sweetListModel.setSweetListCallback(sweetListCallback);
        listLoaderCallbacks = new DbListLoaderCallbackImpl(dbDataLoader, sweetListModel);
        LoaderManager.getInstance(this).initLoader(LOADER_ID, null, listLoaderCallbacks);
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
