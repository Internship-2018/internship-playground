package com.mghelas.internship_playground.sweet_screen.detailed.impl;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.entity.Chocolate;
import com.mghelas.internship_playground.entity.Lollipop;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweet_screen.detailed.MixClickHandler;
import com.mghelas.internship_playground.sweet_screen.detailed.RemoveClickHandler;
import com.mghelas.internship_playground.sweet_screen.detailed.SweetDetailedFragment;
import com.mghelas.internship_playground.sweet_screen.detailed.SweetDetailedNativeView;
import com.mghelas.internship_playground.sweet_screen.detailed.SweetDetailedPresenter;
import com.mghelas.internship_playground.sweet_screen.detailed.SweetDetailedView;

public class SweetDetailedViewImpl implements SweetDetailedView, SweetDetailedNativeView {

    MixClickHandler mixClickHandler;
    RemoveClickHandler removeClickHandler;
    SweetDetailedFragment sweetDetailedFragment;

    @Override
    public int getLayout() {
        return R.layout.fragment_sweet_detailed;
    }

    @Override
    public void initView(SweetDetailedFragment sweetDetailedFragment, SweetDetailedPresenter sweetDetailedPresenter) {
        this.sweetDetailedFragment = sweetDetailedFragment;

        TextView title = sweetDetailedFragment.getView().findViewById(R.id.titleDetailed);
        TextView price = sweetDetailedFragment.getView().findViewById(R.id.priceDetailed);
        TextView weight = sweetDetailedFragment.getView().findViewById(R.id.weightDetailed);
        TextView flavour = sweetDetailedFragment.getView().findViewById(R.id.flavourDetailed);
        TextView flavourLabel = sweetDetailedFragment.getView().findViewById(R.id.flavourLabel);
        Button mixButton = sweetDetailedFragment.getView().findViewById(R.id.mixButton);
        Button removeButton = sweetDetailedFragment.getView().findViewById(R.id.removeButton);
        ImageView imageView = sweetDetailedFragment.getView().findViewById(R.id.imageView);

        Sweet sweet = sweetDetailedPresenter.findById(sweetDetailedFragment.getArguments().getInt("id"));
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
            mixClickHandler.onMixClicked(sweetDetailedFragment.getArguments().getInt("id"));
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

}
