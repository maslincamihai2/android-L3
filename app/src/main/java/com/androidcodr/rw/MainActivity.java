package com.androidcodr.rw;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializeaza lista de produse
        productList = new ArrayList<>();
        productList.add(new Product("Produs 1", "Descriere produs 1", 25.0));
        productList.add(new Product("Produs 2", "Descriere produs 2", 30.0));
        productList.add(new Product("Produs 3", "Descriere produs 3", 25.0));
        productList.add(new Product("Produs 4", "Descriere produs 4", 30.0));
        productList.add(new Product("Produs 5", "Descriere produs 5", 25.0));
        productList.add(new Product("Produs 6", "Descriere produs 6", 30.0));


        RecyclerView recyclerView = findViewById(R.id.recycler_view_products);
        ProductAdapter adapter = new ProductAdapter(productList, new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product) {
                // Deschide ProductDetailsActivity la selectarea unui produs
                Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);
                intent.putExtra("product", product);
                startActivity(intent);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
