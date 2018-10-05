package com.mghelas.internship_playground.start_screen.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.start_screen.presenter.StartPresenterImpl;
import com.mghelas.internship_playground.start_screen.presenter.StartPresenterIntf;

import androidx.navigation.Navigation;

public class StartFragment extends Fragment implements StartViewIntf {
    StartPresenterIntf startPresenter;
    Button stockButton;
    Button addButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        stockButton = view.findViewById(R.id.showStockButton);
        addButton = view.findViewById(R.id.addSweetButton);
        startPresenter = new StartPresenterImpl(this);

        stockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPresenter.onStockClick();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPresenter.onAddClick();
            }
        });
    }


    @Override
    public void stock() {
        Navigation.findNavController(getView()).navigate(R.id.action_startFragment_to_sweetFragment);
    }

    @Override
    public void add() {
        Navigation.findNavController(getView()).navigate(R.id.action_startFragment_to_sweetAddFragment);
    }
}
