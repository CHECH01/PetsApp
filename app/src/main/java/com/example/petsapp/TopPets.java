package com.example.petsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class TopPets extends AppCompatActivity {
    ArrayList <Pets> topPets = new ArrayList<>();
    RecyclerView rvTopPets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_pets);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(getString(R.string.top_pets_activity));

        rvTopPets = findViewById(R.id.rvTopPets);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        topPets = (ArrayList<Pets>) extras.get("top");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvTopPets.setLayoutManager(linearLayoutManager);

        rvTopPets.setAdapter(new PetAdapter(topPets,this));
    }
}