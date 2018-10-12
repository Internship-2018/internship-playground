package com.mghelas.internship_playground.ui.sweetscreen.detailed.impl;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.storage.entity.Chocolate;
import com.mghelas.internship_playground.storage.entity.Lollipop;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.MixClickHandler;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.RemoveClickHandler;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedFragment;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedNativeView;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedPresenter;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedView;

public class SweetDetailedViewImpl implements SweetDetailedView, SweetDetailedNativeView {

    MixClickHandler mixClickHandler;
    RemoveClickHandler removeClickHandler;
    SweetDetailedFragment sweetDetailedFragment;

    TextView title;
    TextView price;
    TextView weight;
    TextView flavour;
    TextView flavourLabel;
    Button mixButton;
    Button removeButton;
    ImageView imageView;

    @Override
    public int getLayout() {
        return R.layout.fragment_sweet_detailed;
    }

    @Override
    public void initView(SweetDetailedFragment sweetDetailedFragment, SweetDetailedPresenter sweetDetailedPresenter) {
        this.sweetDetailedFragment = sweetDetailedFragment;

        title = sweetDetailedFragment.getView().findViewById(R.id.titleDetailed);
        price = sweetDetailedFragment.getView().findViewById(R.id.priceDetailed);
        weight = sweetDetailedFragment.getView().findViewById(R.id.weightDetailed);
        flavour = sweetDetailedFragment.getView().findViewById(R.id.flavourDetailed);
        flavourLabel = sweetDetailedFragment.getView().findViewById(R.id.flavourLabel);
        mixButton = sweetDetailedFragment.getView().findViewById(R.id.mixButton);
        removeButton = sweetDetailedFragment.getView().findViewById(R.id.removeButton);
        imageView = sweetDetailedFragment.getView().findViewById(R.id.imageView);

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
        if (sweet instanceof Chocolate) {
            imageView.setBackgroundResource(R.drawable.ic_chocolate);
            flavourLabel.setText("Percentage");

            flavour.setText(((Chocolate) sweet).getPercentage() + "");
        } else {
            imageView.setBackgroundResource(R.drawable.ic_lollipop);
            flavour.setText(((Lollipop) sweet).getFlavour());
        }
    }

}
