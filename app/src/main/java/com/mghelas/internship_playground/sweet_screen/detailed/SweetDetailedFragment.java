package com.mghelas.internship_playground.sweet_screen.detailed;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mghelas.internship_playground.Entity.Chocolate;
import com.mghelas.internship_playground.Entity.Lollipop;
import com.mghelas.internship_playground.Entity.Sweet;
import com.mghelas.internship_playground.R;

import androidx.navigation.Navigation;

public class SweetDetailedFragment extends Fragment implements SweetDetailedView {

    SweetDetailedPresenterIntf sweetDetailedPresenter;
    Sweet sweet;

    TextView title;
    TextView price;
    TextView weight;
    TextView flavour;
    TextView flavourLabel;
    Button mixButton;
    Button removeButton;
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sweet_detailed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.titleDetailed);
        price = view.findViewById(R.id.priceDetailed);
        weight = view.findViewById(R.id.weightDetailed);
        flavour = view.findViewById(R.id.flavourDetailed);
        flavourLabel = view.findViewById(R.id.flavourLabel);
        mixButton = view.findViewById(R.id.mixButton);
        removeButton = view.findViewById(R.id.removeButton);
        imageView = view.findViewById(R.id.imageView);
        sweetDetailedPresenter = new SweetDetailedPresenterImpl(this);
        sweetDetailedPresenter.findById(getArguments().getInt("id"));

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sweetDetailedPresenter.onRemove(getArguments().getInt("id"));
            }
        });

        mixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sweetDetailedPresenter.onMix(sweet);
            }
        });

    }

    @Override
    public void setData(Sweet sweet) {
        this.sweet = sweet;
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

    @Override
    public void mix(String manufactureProcess) {

        Toast toast = Toast.makeText(this.getContext(),
                manufactureProcess,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void remove() {
        Navigation.findNavController(getView()).navigate(R.id.action_sweetDetailedFragment_to_sweetListFragment);
    }
}
