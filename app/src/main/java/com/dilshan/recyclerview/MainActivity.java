package com.dilshan.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button listBtn, gridBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        listBtn = findViewById(R.id.listBtn);
        gridBtn = findViewById(R.id.gridBtn);

        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("Burger Buns",R.drawable.burger_buns));
        foods.add(new Food("Pizza",R.drawable.pizza));
        foods.add(new Food("KFC",R.drawable.kfc));
        foods.add(new Food("Ravi Charga",R.drawable.ravi_charga));
        foods.add(new Food("Juices Island",R.drawable.juicesisland));
        foods.add(new Food("Savour Food",R.drawable.savour_food));

        FoodAdapter adapter = new FoodAdapter(this,foods);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(linearLayoutManager);
            }
        });

        gridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(gridLayoutManager);
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }
}