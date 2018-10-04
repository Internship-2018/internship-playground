package com.mghelas.internship_playground.StartScreen;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mghelas.internship_playground.R;

import androidx.navigation.Navigation;

public class StartFragment extends Fragment implements StartViewIntf {
    StartPresenterIntf startPresenter;
    Button stockButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        stockButton = view.findViewById(R.id.showStockButton);
        startPresenter = new StartPresenterImpl(this);

        stockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPresenter.viewStock();
            }
        });
    }


    @Override
    public void goToStock() {
        Navigation.findNavController(getView()).navigate(R.id.action_startFragment_to_sweetFragment);
    }
}
