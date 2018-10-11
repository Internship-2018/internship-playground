package com.example.nciuclea.oopzoomvp.welcome;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nciuclea.oopzoomvp.R;

import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment implements WelcomeView {

    private WelcomePresenter presenter;
    private TextView zooName;
    private Button enterButton;

    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        zooName = view.findViewById(R.id.zoo_name);
        enterButton = view.findViewById(R.id.enter_button);
        presenter = new WelcomePresenterImpl(this, new WelcomeModelImpl());

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onEnterButtonClicked();
            }
        });
        presenter.onInitUI();
    }

    @Override
    public void onSetZooName(String zooNameText) {
        zooName.setText(zooNameText);
    }

    @Override
    public void onSetButtonName(String buttonName) {
        enterButton.setText(buttonName);
    }

    @Override
    public void startZooView() {
        Log.d("PROF_LOG", "StartZooView called");
        Navigation.findNavController(getView()).navigate(R.id.action_welcomeFragment_to_allAnimalsFragment);
    }


}
