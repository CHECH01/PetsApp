package com.example.petsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements Serializable {

    RecyclerView rvPets;

    ArrayList<Pets> pets= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPets = findViewById(R.id.rvPets);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rvPets.setLayoutManager(linearLayoutManager);

        addPets();
        rvPets.setAdapter(new PetAdapter(pets,this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.itmTopPets){
            goTopPets();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }


    public void addPets(){
        pets.add(new Pets(R.drawable.tiger,"Tiger",11));
        pets.add(new Pets(R.drawable.lion,"Lion",15));
        pets.add(new Pets(R.drawable.cat,"Cat",7));
        pets.add(new Pets(R.drawable.hamster,"Hamster",1));
        pets.add(new Pets(R.drawable.panda,"Panda",5));
        pets.add(new Pets(R.drawable.chicken,"Chicken",2));
        pets.add(new Pets(R.drawable.rabbit,"Rabbit",0));
        pets.add(new Pets(R.drawable.dog,"Dog",6));
    }
    public ArrayList<Pets> getTopPets(){
        ArrayList<Pets> topPets = new ArrayList<>(pets);
        Collections.sort(topPets, Collections.<Pets>reverseOrder());

        if (pets.size() > 5)
            topPets.subList(5, pets.size()).clear();

        return topPets;
    }
    public void goTopPets(){
        Intent i = new Intent(this,TopPets.class);
        i.putExtra("top",getTopPets());
        startActivity(i);
    }

}
