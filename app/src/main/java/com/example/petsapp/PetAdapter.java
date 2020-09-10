package com.example.petsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolderPet>{
    ArrayList <Pets> pets;
    Activity activity;

    public PetAdapter(ArrayList<Pets> pets,Activity activity) {
        this.pets = pets;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolderPet onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pets_cardview,parent,false);
        return new ViewHolderPet(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderPet holder, int position) {
        final Pets pet = pets.get(position);

        holder.imgPet.setImageResource(pet.getImgPet());
        holder.tvName.setText(pet.getName());
        holder.tvLikes.setText(String.valueOf(pet.getLikes()));
        if(activity.getClass().getName().equals(TopPets.class.getName()))
            holder.btnLike.setVisibility(View.INVISIBLE);
        else{
            holder.btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pet.setLikes(pet.getLikes()+1);
                    holder.tvLikes.setText(String.valueOf(pet.getLikes()));
                }
            });
        }

    }
    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class ViewHolderPet extends RecyclerView.ViewHolder{
        private ImageView imgPet;
        private TextView tvName, tvLikes;
        private ImageButton btnLike;

        public ViewHolderPet(@NonNull View itemView) {
            super(itemView);
            imgPet = itemView.findViewById(R.id.imgPet);
            tvName = itemView.findViewById(R.id.tvName);
            tvLikes = itemView.findViewById(R.id.tvLikes);
            btnLike = itemView.findViewById(R.id.btnLike);
        }
    }
}
