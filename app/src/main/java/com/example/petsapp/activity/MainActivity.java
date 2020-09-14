package com.example.petsapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.petsapp.R;
import com.example.petsapp.adapter.PageAdapter;
import com.example.petsapp.fragment.HomeFragment;
import com.example.petsapp.fragment.ProfileFragment;
import com.example.petsapp.pojo.Pets;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements Serializable {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ArrayList<Pets> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
         if(toolbar != null)
            setSupportActionBar(toolbar);
        setUpViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itmTopPets:
                goTopPets();
                break;
            case R.id.itmContact:
                goContact();
                break;
            case R.id.itmAbout:
                goAbout();
                break;
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

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, addFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.pets);
    }
    public ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        pets = new ArrayList<>(homeFragment.getPets());
        fragments.add(homeFragment);
        fragments.add(new ProfileFragment());
        return fragments;
    }
    public void goContact(){
        Intent i = new Intent(this, Contact.class);
        startActivity(i);
    }
    public void goAbout(){
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }

}
