package com.mghelas.internship_playground.sweet_screen.add;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.R;

public class SweetAddFragment extends Fragment implements SweetAddViewIntf{
    SweetAddPresenterIntf sweetAddPresenter;

    EditText title;
    EditText weight;
    EditText price;
    EditText flavour;
    RadioButton chocolateToggle;
    RadioButton lollipopToggle;
    Switch pricePerKgToggle;
    Switch milkToggle;
    Switch sugarToggle;
    Switch cocoaToggle;
    Button addButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sweet_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        sweetAddPresenter = new SweetAddPresenterImpl(this);
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.titleTextEdit);
        weight= view.findViewById(R.id.weightEditText);
        price = view.findViewById(R.id.priceEditText);
        flavour = view.findViewById(R.id.flavourEditText);
        chocolateToggle = view.findViewById(R.id.isChocolate);
        lollipopToggle= view.findViewById(R.id.isLollipop);
        pricePerKgToggle= view.findViewById(R.id.pricePerKgSwitch);
        milkToggle= view.findViewById(R.id.milkSwitch);
        sugarToggle= view.findViewById(R.id.sugarSwitch);
        cocoaToggle= view.findViewById(R.id.cocoaSwitch);
        addButton= view.findViewById(R.id.createSweetButton);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chocolateToggle.isChecked()){
//                    Chocolate chocolate = new Chocolate(title.getText(), price.getText(), weight.getText(), )
                }
//                sweetAddPresenter.onAdd();
            }
        });

    }

    @Override
    public void addClick(Sweet sweet) {

    }

    @Override
    public void toggleRadio() {

    }
}
