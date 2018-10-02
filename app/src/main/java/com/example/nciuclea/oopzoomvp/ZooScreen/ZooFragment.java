package com.example.nciuclea.oopzoomvp.ZooScreen;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nciuclea.oopzoomvp.Animal.Animal;
import com.example.nciuclea.oopzoomvp.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZooFragment extends Fragment implements ZooView {

    private ZooPresenter presenter;
    private RecyclerView zooRecyclerView;
    private AnimalAdapter animalAdapter;
    private RecyclerView.LayoutManager zooLayoutManager;

    public ZooFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zoo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new ZooPresenterImpl(this, new ZooModelImpl());
        zooRecyclerView = view.findViewById(R.id.zoo_recyclerview);
        zooRecyclerView.setHasFixedSize(true);
        zooLayoutManager = new LinearLayoutManager(view.getContext());
        zooRecyclerView.setLayoutManager(zooLayoutManager);
        animalAdapter = new AnimalAdapter(null);
        presenter.onRecyclerViewReady();
        zooRecyclerView.setAdapter(animalAdapter);
    }

    @Override
    public void updateAnimalList(List<Animal> newAnimalList) { animalAdapter.updateAnimalList(newAnimalList); }
}
