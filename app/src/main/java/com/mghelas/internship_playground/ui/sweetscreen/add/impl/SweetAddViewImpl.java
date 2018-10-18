package com.mghelas.internship_playground.ui.sweetscreen.add.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.storage.entity.Ingredient;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.add.AddClickHandler;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddFragment;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddNativeView;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddPresenter;
import com.mghelas.internship_playground.ui.sweetscreen.add.SweetAddView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SweetAddViewImpl implements SweetAddView, SweetAddNativeView, AdapterView.OnItemSelectedListener {

    private AddClickHandler addClickHandler;
    private LinearLayout switchContainer;
    private SweetAddFragment sweetAddFragment;
    private Spinner spinner;
    private Calendar c;

    @Override
    public int getLayout() {
        return R.layout.fragment_sweet_add;
    }

    @Override
    public void initView(final SweetAddFragment sweetAddFragment, SweetAddPresenter sweetAddPresenter) {
        this.sweetAddFragment = sweetAddFragment;
        final Button addBtn = sweetAddFragment.getView().findViewById(R.id.create_sweet_btn);
        final EditText title = sweetAddFragment.getView().findViewById(R.id.name_add);
        final EditText type = sweetAddFragment.getView().findViewById(R.id.type_add);
        final EditText confectionerName = sweetAddFragment.getView().findViewById(R.id.confectioner_name_add);
        final CalendarView expiryDate = sweetAddFragment.getView().findViewById(R.id.expiry_date_add);
        expiryDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                 c = Calendar.getInstance();
                c.set(year, month, dayOfMonth);
            }
        });
        spinner = sweetAddFragment.getView().findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        switchContainer = sweetAddFragment.getView().findViewById(R.id.switch_container);
        sweetAddPresenter.getAllIngredients();
        c = Calendar.getInstance();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                Sweet sweet = new Sweet(title.getText().toString(),
                        type.getText().toString(),
                        sdf.format(c.getTime()) + "",
                        confectionerName.getText().toString());
                List<Ingredient> ingredients = getIngredients(switchContainer);
                sweet.setIngredients(ingredients);

                onAddClicked(sweet);
            }
        });
    }

    @NonNull
    private List<Ingredient> getIngredients(LinearLayout switchContainer) {

        List<Ingredient> ingredients = new ArrayList<>();

        for (int i = 0; i < switchContainer.getChildCount(); i = i + 2) {
            TextView s = (TextView) switchContainer.getChildAt(i);
            EditText quantity = (EditText) switchContainer.getChildAt(i + 1);
            Ingredient ingredient = new Ingredient(s.getId(), s.getText().toString(), Double.parseDouble(quantity.getText().toString()));
            ingredients.add(ingredient);
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
        ingredients.add(0, new Ingredient("Select an ingredient"));
        ArrayAdapter<Ingredient> dataAdapter = new ArrayAdapter<>(sweetAddFragment.getContext(),
                R.layout.support_simple_spinner_dropdown_item,
                ingredients);
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void showError(String error) {
        Toast toast = Toast.makeText(sweetAddFragment.getContext(),
                error,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position != 0) {
            Ingredient ingredient = (Ingredient) parent.getItemAtPosition(position);
            TextView textView = new TextView(sweetAddFragment.getContext());
            textView.setId(ingredient.getId());
            textView.setText(ingredient.getName());
            switchContainer.addView(textView);

            EditText quantity = new EditText(sweetAddFragment.getContext());
            quantity.setHint("Quantity");
            switchContainer.addView(quantity);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
