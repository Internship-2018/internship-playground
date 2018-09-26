package com.mghelas.internship_playground;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mghelas.internship_playground.sweetsfactory.Chocolate;

public class AllProductsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);

        LinearLayout productsLl = findViewById(R.id.productsLl);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(30, 20, 30, 0);


        Chocolate chocolate = new Chocolate();
        chocolate.setTitle("Meteorit");
        chocolate.setPrice(50.0);
        chocolate.setPricePerKg(true);
        chocolate.setWeight(10.0);
        chocolate.setPercentage(50);
        for (int i = 0; i < 20; i++) {
            LinearLayout product = new LinearLayout(this);
            product.setOrientation(LinearLayout.HORIZONTAL);


            TextView title = new TextView(this);
            title.setText("Title: \n" + chocolate.getTitle());
            product.addView(title, layoutParams);

            TextView price = new TextView(this);
            price.setText(chocolate.getPricePerKg() ? "Price/kg: \n" + chocolate.getPrice() : "Price: \n" + chocolate.getPrice());
            product.addView(price, layoutParams);

            TextView weight = new TextView(this);
            weight.setText("Wieght: \n" + chocolate.getWeight());
            product.addView(weight, layoutParams);

            TextView chocolatePercentage = new TextView(this);
            chocolatePercentage.setText("Chocolate %: \n" + chocolate.getPercentage());
            product.addView(chocolatePercentage, layoutParams);


            productsLl.addView(product);
        }
    }

}
