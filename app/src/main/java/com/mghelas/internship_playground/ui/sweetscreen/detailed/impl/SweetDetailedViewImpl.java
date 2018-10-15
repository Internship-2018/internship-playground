package com.mghelas.internship_playground.ui.sweetscreen.detailed.impl;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.MixClickHandler;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.RemoveClickHandler;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedFragment;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedNativeView;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedPresenter;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedView;

public class SweetDetailedViewImpl implements SweetDetailedView, SweetDetailedNativeView {

    private MixClickHandler mixClickHandler;
    private RemoveClickHandler removeClickHandler;
    private SweetDetailedFragment sweetDetailedFragment;

    private TextView title;
    private TextView price;
    private TextView weight;
    private Button mixButton;
    private Button removeButton;

    @Override
    public int getLayout() {
        return R.layout.fragment_sweet_detailed;
    }

    @Override
    public void initView(SweetDetailedFragment sweetDetailedFragment, SweetDetailedPresenter sweetDetailedPresenter) {
        this.sweetDetailedFragment = sweetDetailedFragment;

        title = sweetDetailedFragment.getView().findViewById(R.id.nameDetailed);
        price = sweetDetailedFragment.getView().findViewById(R.id.typeDetailed);
        weight = sweetDetailedFragment.getView().findViewById(R.id.expiryDateDetailed);
        mixButton = sweetDetailedFragment.getView().findViewById(R.id.mixButton);
        removeButton = sweetDetailedFragment.getView().findViewById(R.id.removeButton);

        sweetDetailedPresenter.findById(sweetDetailedFragment.getArguments().getInt("id"));


        mixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMixClicked();
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRemoveClicked();
            }
        });


    }

    private void onRemoveClicked() {
        if (removeClickHandler != null) {
            removeClickHandler.onRemoveClicked(sweetDetailedFragment.getArguments().getInt("id"));
        }
    }

    private void onMixClicked() {
        if (mixClickHandler != null) {
            mixClickHandler.onMixClicked();
        }
    }

    @Override
    public void setOnMixClickHandler(MixClickHandler mixClickHandler) {
        this.mixClickHandler = mixClickHandler;
    }

    @Override
    public void setOnRemoveClickHandler(RemoveClickHandler removeClickHandler) {
        this.removeClickHandler = removeClickHandler;
    }

    @Override
    public void mixShow(String message) {
        Toast toast = Toast.makeText(sweetDetailedFragment.getContext(),
                message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void bindData(Sweet sweet) {
        title.setText(sweet.getTitle());
        price.setText(sweet.getPrice() + "");
        weight.setText(sweet.getWeight() + "");
    }

}
