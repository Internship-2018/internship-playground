package com.mghelas.internship_playground.sweetscreen.add.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.entity.Chocolate;
import com.mghelas.internship_playground.entity.Ingredient;
import com.mghelas.internship_playground.entity.Lollipop;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.add.AddClickHandler;
import com.mghelas.internship_playground.sweetscreen.add.SweetAddFragment;
import com.mghelas.internship_playground.sweetscreen.add.SweetAddNativeView;
import com.mghelas.internship_playground.sweetscreen.add.SweetAddPresenter;
import com.mghelas.internship_playground.sweetscreen.add.SweetAddView;
import com.mghelas.internship_playground.sweetscreen.add.SweetTypeRadioHandler;

import java.util.ArrayList;
import java.util.List;

public class SweetAddViewImpl implements SweetAddView, SweetAddNativeView {

    private AddClickHandler addClickHandler;
    private SweetTypeRadioHandler sweetTypeRadioHandler;
    EditText flavour;
    LinearLayout switchContainer;

    @Override
    public int getLayout() {
        return R.layout.fragment_sweet_add;
    }

    @Override
    public void initView(final SweetAddFragment sweetAddFragment, SweetAddPresenter sweetAddPresenter) {
        final Button addBtn = sweetAddFragment.getView().findViewById(R.id.create_sweet_btn);
        final RadioGroup sweetType = sweetAddFragment.getView().findViewById(R.id.sweet_type);
        final RadioButton isChocolate = sweetAddFragment.getView().findViewById(R.id.is_chocolate);
        final RadioButton isLollipop = sweetAddFragment.getView().findViewById(R.id.is_lollipop);
        final EditText title = sweetAddFragment.getView().findViewById(R.id.title_add);
        final EditText price = sweetAddFragment.getView().findViewById(R.id.price_add);
        final EditText weight = sweetAddFragment.getView().findViewById(R.id.weight_add);
        final Switch pricePerKg = sweetAddFragment.getView().findViewById(R.id.price_per_kg_add);
        flavour = sweetAddFragment.getView().findViewById(R.id.flavour_add);
        switchContainer = sweetAddFragment.getView().findViewById(R.id.switch_container);
        for (Ingredient ingredient : sweetAddPresenter.getAllIngredients()) {
            Switch aSwitch = new Switch(sweetAddFragment.getContext());
            aSwitch.setId(ingredient.getId());
            aSwitch.setText(ingredient.getTitle());
            switchContainer.addView(aSwitch);
        }

        sweetType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.is_chocolate) {
                    onRadioChanged("Percentage");
                } else {
                    onRadioChanged("Flavour");
                }

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Sweet sweet;
                if (isChocolate.isChecked()) {
                    sweet = new Chocolate(title.getText().toString(),
                            Double.parseDouble(price.getText().toString()),
                            Double.parseDouble(weight.getText().toString()),
                            pricePerKg.isChecked(), Integer.parseInt(flavour.getText().toString()));
                    List<Ingredient> ingredients = getIngredients(switchContainer);
                    sweet.setIngredients(ingredients);

                } else {
                    sweet = new Lollipop(title.getText().toString(),
                            Double.parseDouble(price.getText().toString()),
                            Double.parseDouble(weight.getText().toString()),
                            pricePerKg.isChecked(), flavour.getText().toString());
                    List<Ingredient> ingredients = getIngredients(switchContainer);
                    sweet.setIngredients(ingredients);
                }
                onAddClicked(sweet);
            }
        });
    }

    @NonNull
    private List<Ingredient> getIngredients(LinearLayout switchContainer) {
        List<Ingredient> ingredients = new ArrayList<>();

        for (int i = 0; i < switchContainer.getChildCount(); i++) {
            Switch s = (Switch) switchContainer.getChildAt(i);
            if (s.isChecked()) {
                Ingredient ingredient = new Ingredient(s.getId(), s.getText().toString());
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }

    private void onAddClicked(Sweet sweet) {
        if (addClickHandler != null) {
            addClickHandler.onAddClicked(sweet);
        }
    }

    private void onRadioChanged(String type) {
        if (sweetTypeRadioHandler != null) {
            sweetTypeRadioHandler.onRadioChanged(type);
        }
    }

    @Override
    public void setOnAddClickHandler(AddClickHandler addClickHandler) {
        this.addClickHandler = addClickHandler;
    }

    @Override
    public void setOnTypeChangeHandler(SweetTypeRadioHandler sweetTypeRadioHandler) {
        this.sweetTypeRadioHandler = sweetTypeRadioHandler;
    }

    @Override
    public void changeSweetType(String type) {
        flavour.setHint(type);
    }
}
