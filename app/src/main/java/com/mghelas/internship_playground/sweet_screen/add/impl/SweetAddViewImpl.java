package com.mghelas.internship_playground.sweet_screen.add.impl;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TableLayout;

import com.mghelas.internship_playground.Ingredients;
import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.entity.Chocolate;
import com.mghelas.internship_playground.entity.Ingredient;
import com.mghelas.internship_playground.entity.Lollipop;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweet_screen.add.AddClickHandler;
import com.mghelas.internship_playground.sweet_screen.add.SweetAddFragment;
import com.mghelas.internship_playground.sweet_screen.add.SweetAddNativeView;
import com.mghelas.internship_playground.sweet_screen.add.SweetAddPresenter;
import com.mghelas.internship_playground.sweet_screen.add.SweetAddView;
import com.mghelas.internship_playground.sweet_screen.add.SweetTypeRadioHandler;

import java.util.ArrayList;
import java.util.List;

public class SweetAddViewImpl implements SweetAddView, SweetAddNativeView {

    private AddClickHandler addClickHandler;
    private SweetTypeRadioHandler sweetTypeRadioHandler;
    EditText flavour;

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
        final Switch milk = sweetAddFragment.getView().findViewById(R.id.milk_add);
        final Switch cocoa = sweetAddFragment.getView().findViewById(R.id.cocoa_add);
        final Switch sugar = sweetAddFragment.getView().findViewById(R.id.sugar_add);
        flavour = sweetAddFragment.getView().findViewById(R.id.flavour_add);
        final RelativeLayout switchContainer = sweetAddFragment.getView().findViewById(R.id.switch_container);
        System.out.println(sweetAddPresenter.getAllIngredients().toString());
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
//                    ingredients.add(((Lollipop) sweet).getFlavour() + " concentrate");
                    sweet.setIngredients(ingredients);
                }
                onAddClicked(sweet);
            }
        });
    }

    @NonNull
    private List<Ingredient> getIngredients(RelativeLayout switchContainer) {
        List<Ingredient> ingredients = new ArrayList<>();

        for (int i = 0; i < switchContainer.getChildCount(); i++) {
            Switch s = (Switch) switchContainer.getChildAt(i);
            if (s.isChecked()) {
                Ingredient ingredient = new Ingredient(s.getId(), s.getText().toString());
                ingredients.add(ingredient);
            }
        }
//        if (milk.isChecked()) {
//            ingredients.add(milk.getText().toString());
//        }
//        if (cocoa.isChecked()) {
//            ingredients.add(cocoa.getText().toString());
//        }
//        if (sugar.isChecked()) {
//            ingredients.add(sugar.getText().toString());
//        }
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
