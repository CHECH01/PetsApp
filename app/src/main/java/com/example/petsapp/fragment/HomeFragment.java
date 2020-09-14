package com.example.petsapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petsapp.adapter.PetAdapter;
import com.example.petsapp.pojo.Pets;
import com.example.petsapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private RecyclerView rvPets;
    private ArrayList<Pets> pets= new ArrayList<>();

    public HomeFragment() {
        addPets();
    }

    public ArrayList<Pets> getPets() {
        return pets;
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvPets = view.findViewById(R.id.rvPets);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        rvPets.setLayoutManager(linearLayoutManager);

        rvPets.setAdapter(new PetAdapter(pets,getActivity(),this));
        return view;
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
}