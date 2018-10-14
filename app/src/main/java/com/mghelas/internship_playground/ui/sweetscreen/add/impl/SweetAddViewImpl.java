package com.mghelas.internship_playground.ui.sweetscreen.add.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.storage.entity.Ingredient;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.add.AddClickHandler;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddFragment;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddNativeView;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddPresenter;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddView;

import java.util.ArrayList;
import java.util.List;

public class SweetAddViewImpl implements SweetAddView, SweetAddNativeView {

    private AddClickHandler addClickHandler;
    private LinearLayout switchContainer;
    private SweetAddFragment sweetAddFragment;

    @Override
    public int getLayout() {
        return R.layout.fragment_sweet_add;
    }

    @Override
    public void initView(final SweetAddFragment sweetAddFragment, SweetAddPresenter sweetAddPresenter) {
        this.sweetAddFragment = sweetAddFragment;
        final Button addBtn = sweetAddFragment.getView().findViewById(R.id.create_sweet_btn);
        final EditText title = sweetAddFragment.getView().findViewById(R.id.title_add);
        final EditText price = sweetAddFragment.getView().findViewById(R.id.price_add);
        final EditText weight = sweetAddFragment.getView().findViewById(R.id.weight_add);
        final Switch pricePerKg = sweetAddFragment.getView().findViewById(R.id.price_per_kg_add);
        switchContainer = sweetAddFragment.getView().findViewById(R.id.switch_container);
        sweetAddPresenter.getAllIngredients();


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sweet sweet = new Sweet(title.getText().toString(),
                        Double.parseDouble(price.getText().toString()),
                        Double.parseDouble(weight.getText().toString()),
                        pricePerKg.isChecked());
                List<Ingredient> ingredients = getIngredients(switchContainer);
                sweet.setIngredients(ingredients);


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

    @Override
    public void setOnAddClickHandler(AddClickHandler addClickHandler) {
        this.addClickHandler = addClickHandler;
    }

    @Override
    public void bindData(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            Switch aSwitch = new Switch(sweetAddFragment.getContext());
            aSwitch.setId(ingredient.getId());
            aSwitch.setText(ingredient.getTitle());
            switchContainer.addView(aSwitch);
        }
    }
}
