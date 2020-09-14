package com.example.petsapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petsapp.R;
import com.example.petsapp.adapter.PetAdapter;
import com.example.petsapp.pojo.Pets;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    RecyclerView rvMyPics;
    ArrayList<Pets> pics = new ArrayList<>();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        addPics();
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        rvMyPics = view.findViewById(R.id.rvMyPics);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        rvMyPics.setLayoutManager(gridLayoutManager);
        rvMyPics.setAdapter(new PetAdapter(pics,getActivity(),this));
        return view;
    }
    public void addPics(){
        pics.add(new Pets(R.drawable.dog2,"",2));
        pics.add(new Pets(R.drawable.dog3,"",5));
        pics.add(new Pets(R.drawable.dog4,"",10));
        pics.add(new Pets(R.drawable.dog5,"",3));
        pics.add(new Pets(R.drawable.dog6,"",9));
        pics.add(new Pets(R.drawable.dog,"",6));
        pics.add(new Pets(R.drawable.dog7,"",4));
        pics.add(new Pets(R.drawable.dog8,"",11));

    }
}