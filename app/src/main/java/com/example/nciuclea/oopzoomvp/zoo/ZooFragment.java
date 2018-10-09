package com.example.nciuclea.oopzoomvp.zoo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nciuclea.oopzoomvp.animal.Animal;
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
        Log.d(LOG_TAG, "Fragment1 onCreateView");
        return inflater.inflate(R.layout.fragment_zoo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onViewCreated");
        presenter = new ZooPresenterImpl(this, new ZooModelImpl());
        zooRecyclerView = view.findViewById(R.id.zoo_recyclerview);
        zooRecyclerView.setHasFixedSize(true);
        zooLayoutManager = new LinearLayoutManager(view.getContext());
        zooRecyclerView.setLayoutManager(zooLayoutManager);
        animalAdapter = new AnimalAdapter(null);
        presenter.onInitRecyclerView();
        zooRecyclerView.setAdapter(animalAdapter);
    }

    String LOG_TAG = "Frag_LC";

    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "Fragment1 onStart");
    }

    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Fragment1 onResume");
    }

    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Fragment1 onPause");
    }

    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "Fragment1 onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "Fragment1 onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "Fragment1 onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "Fragment1 onDetach");
    }

    @Override
    public void updateAnimalList(List<Animal> newAnimalList) { animalAdapter.updateAnimalList(newAnimalList); }
}
