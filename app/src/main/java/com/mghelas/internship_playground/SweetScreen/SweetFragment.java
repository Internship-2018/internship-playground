package com.mghelas.internship_playground.SweetScreen;

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
import com.mghelas.internship_playground.Model.Sweet;

import java.util.ArrayList;
import java.util.List;

public class SweetFragment extends Fragment implements SweetViewIntf {

    private List<Sweet> sweetsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private SweetPresenterIntf sweetPresenter;

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public List<Sweet> getSweetsList() {
        return sweetsList;
    }

    SweetsAdapter sweetsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sweet_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        sweetPresenter = new SweetPresenterImpl(this);
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.fragment_sweet_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        sweetPresenter.getChocolateItems();
        sweetPresenter.getLollipopItems();

    }


    @Override
    public void populateView() {
        sweetPresenter.setAdapter(new SweetsAdapter(sweetsList));
    }
}
