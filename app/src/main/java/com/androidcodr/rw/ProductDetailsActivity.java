package com.androidcodr.rw;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        TextView productNameTextView = findViewById(R.id.text_view_product_name);
        TextView productDescriptionTextView = findViewById(R.id.text_view_product_description);
        TextView productPriceTextView = findViewById(R.id.text_view_product_price);

        // Preia detaliile produsului selectat
        if (getIntent().hasExtra("product")) {
            Product product = getIntent().getParcelableExtra("product");
            if (product != null) {
                productNameTextView.setText(product.getName());
                productDescriptionTextView.setText(product.getDescription());
                productPriceTextView.setText(String.valueOf(product.getPrice()));
            }
        }


    }
}
